import java.util.Scanner;

public class Bank extends Account{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		Account temp = null;
		int ch;
		while (true)	{
			System.out.println("1. Add New Account\n2. Existing Account\n3. Exit");
			System.out.print("Enter Choice: ");
			ch = inp.nextInt();
			switch(ch)	{
			case 1:
				temp = new Account();
				temp.getInformation();
				ACS[NumberOfAccounts] = temp;
				NumberOfAccounts++;
				break;
			case 2:
				System.out.println("Enter the Account Number: ");
				int AccNum = inp.nextInt();
				Account currentAccount = SearchAccountNumber(AccNum);
				if(currentAccount == null)	{
					System.out.println("Account Not Found");
					break;
				}
				outside:
				while(true)	{
					System.out.println("1.Deposit\n2.Withdraw\n3.Transfer\n4.Display Details\n5.Return to main menu");
					int chs = inp.nextInt();
					boolean status = false;
					switch(chs)	{
					case 1:
						status = currentAccount.deposit();
						break;
					case 2:
						status = currentAccount.withdraw();
						break;
					case 3:
						System.out.println("Enter Account number to transfer to: ");
						int transferAccount = inp.nextInt();
						Account transferAcc = SearchAccountNumber(transferAccount);
						if(transferAcc == null)	{
							System.out.println("Account Not Found");
							break;
						}
						transferAcc.transferTo(currentAccount.transferFrom());
					case 4:
						break outside;
					default:
						System.out.println("Invalid Choice");
					}
					if(status)
						System.out.println("Transaction Successful");
					else
						System.out.println("Transaction Failure");
				}
				break;
			case 3:
				inp.close();
				return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

}