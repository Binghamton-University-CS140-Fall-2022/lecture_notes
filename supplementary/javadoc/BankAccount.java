/**
 * The BankAccount class is used to implement a simple bank account. 
 * @author bailey
 * @version 0.99
 */

public class BankAccount
{
	/**
	 * Field representing the account owners last name.
	 */
	protected String ownerLastName;
	
	/**
	 * Field representing the account owners first name.
	 */
	public String ownerFirstName;
	
	/**
	 * Field representing the account number.
	 */
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	/**
	 * The class constructor. The checking and savings balance are initialized to zero.
	 * @author bailey
	 * @version 0.99
	 * @param ownerLastName the account owner's last name
	 * @param ownerFirstName the account owner's first name
	 * @param accountNumber the account number
	 */
	public BankAccount(String ownerLastName, String ownerFirstName, String accountNumber)
	{
		this.ownerLastName = ownerLastName;
		this.ownerFirstName = ownerFirstName;
		this.accountNumber = accountNumber;
		this.checkingBalance = 0.0;
		this.savingsBalance = 0.0;
	}
		
	/**
	 * This method is used to withdraw funds from the checking balance of the account.
	 * @param amount the amount to withdraw
	 * @return boolean value specifying whether the withdrawal was or was not successful
	 */
	public boolean withdrawFromChecking(double amount)
	{
		return false;
	}
	
	/**
	 * This method is used to withdraw funds from the savings balance of the account.
	 * @param amount the amount to withdraw
	 * @return boolean value specifying whether the withdrawal was or was not successful
	 */
	public boolean withdrawFromSavings(double amount)
	{
		return false;
	}
	
	/**
	 * This method is used to transfer funds from the savings balance to the checking balance of the account.
	 * @param amount the amount to transfer
	 * @return boolean value specifying whether the transfer was or was not successful
	 */
	public boolean transferFromSavingsToChecking(double amount)
	{
		return false;
	}
	
	/**
	 * This method is used to transfer funds from the checking balance to the savings balance of the account.
	 * @param amount the amount to transfer
	 * @return boolean value specifying whether the transfer was or was not successful
	 */
	public boolean transferFromCheckingToSavings(double amount)
	{
		return false;
	}
	
	/**
	 * This method is used to deposit funds to the savings balance of the account.
	 * @param amount the amount to deposit
	 */
	public void depositToSavings(double amount)
	{
	}
	
	/**
	 * This method is used to deposit funds to the checking balance of the account.
	 * @param amount the amount to deposit
	 */
	public void depositToChecking(double amount)
	{
	}
	
	/**
	 * This method is used to return a string representation of the account.
	 * @return String String representation of the account
	 */
	public String toString()
	{
		String result = ownerLastName + ", " + ownerFirstName + ", " + accountNumber + "\n";
		result = result + checkingBalance + "\n";
		result = result + savingsBalance;
		return result;
	}
	
	/**
	 * This method is used to return the account owner's last name.
	 * @return String account owner's last name
	 */
	public String getOwnerLastName()
	{
		return ownerLastName;
	}
	
	/**
	 * This method is used to return the account owner's first name.
	 * @return String account owner's first name
	 */
	public String getOwnerFirstName()
	{
		return ownerFirstName;
	}
	
	/**
	 * This method is used to return the account number.
	 * @return String account number
	 */
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	/**
	 * This method is used to return the account's checking balance.
	 * @return double checking balance
	 */
	public double getCheckingBalance()
	{
		return checkingBalance;
	}
	
	/**
	 * This method is used to return the account's savings balance.
	 * @return double savings balance
	 */
	public double getSavingsBalance()
	{
		return savingsBalance;
	}	
}
