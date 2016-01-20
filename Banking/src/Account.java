import java.util.*;

public class Account {
	private int accountNumber;
	private String name;
	private double balance;
	Scanner inp;
	public static Account ACS[];
	public static int NumberOfAccounts;
	
	public Account()	{
		accountNumber = 0;
		name = "";
		balance = 0.0;
		inp = new Scanner(System.in);
		NumberOfAccounts = 0;
	}
	public void getInformation()	{
		System.out.print("Enter Name: ");
		this.name = inp.next();
		System.out.print("Enter Account Number: ");
		this.accountNumber = inp.nextInt();
		System.out.print("Enter the Starting balance: ");
		this.balance = inp.nextDouble();
		System.out.println("Account Added\n");
	}
	public void showDetails()	{
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Name: " + name);
		System.out.println("Balance: " + balance);
	}
	public boolean deposit()	{
		System.out.print("Enter the amount to deposit: ");
		double depositAmount = inp.nextDouble();
		if(depositAmount < 1)	{
			System.out.println("Invalid Amount!");
			return false;
		}
		this.balance += depositAmount;
		return true;
	}
	public boolean withdraw()	{
		System.out.print("Enter the amount to withdraw: ");
		double withdrawAmount = inp.nextDouble();
		if(withdrawAmount < 1)	{
			System.out.println("Invalid Amount!");
			return false;
		}
		else if(withdrawAmount > this.balance)	{
			System.out.println("Insufficient Balance");
			return false;
		}
		this.balance -= withdrawAmount;
		return true;
	}
	public double transferFrom()	{
		System.out.println("Enter Amount to transfer: ");
		double transferAmount = inp.nextDouble();
		if(transferAmount < 1)	{
			System.out.println("Invalid Amount");
			return 0;
		}
		else if(transferAmount >  this.balance){
			System.out.println("Insufficient Balance");
			return 0;
		}
		this.balance -= transferAmount;
		return transferAmount;
	}
	public boolean transferTo(double transferAmount)	{
		if(transferAmount > 0){
			this.balance += transferAmount;
			return true;
		}
		return false;
	}
	public static Account SearchAccountNumber(int AccNum)	{
		for(Account A: ACS)	{
			if(A.accountNumber == AccNum)	{
				return A;
			}
		}
		return null;
	}
	public void finalize()	{
		inp.close();
	}
}