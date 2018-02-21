/** 
 * @author Stanislav Yanakiev
 * 
 * MyATM
 * 
 * All Rights Reserved to Author
 */
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Creates a BankAccount and a cash card associated with that account
 */
public class BankAccount
{
	private int bankAccount;
	private int accountNumber;
	private CashCard card;
	private double balance;
	private String password;
	private String name;
	
	/**
	 * Creates a BankAccount with a BankID, AccountNumber, Balance, Password, and Name
	 * @param id BankID
	 * @param accNum Account Number
	 * @param amount Balance
	 * @param pw Password used for verification at ATMs
	 * @param name Name of Person
	 */
	public BankAccount(int id, int accNum, double amount, String pw, String name)
	{
		bankAccount = id;
		accountNumber = accNum;
		balance = amount;
		password = pw;
		this.name = name;
		
		String cardNumber = bankAccount + "" + accountNumber;
		GregorianCalendar expDate = new GregorianCalendar();
		expDate.
		add(Calendar.YEAR, 4);
		card = new CashCard(cardNumber, expDate, pw);
	}
	
	/**
	 * Communicated from the ATM to withdraw specified amount from balance
	 * @param amount amount to withdraw
	 */
	public void moneyWithdrawn(int amount)
	{
		balance = balance - amount;
		card.addTransaction(amount);
		
	}
	
	/**
	 * Gets the accountID
	 * @return accountNumber
	 */
	public int getAccountID()
	{
		return accountNumber;
	}
	
	/**
	 * Gets the cash card associated with the account
	 * @return card
	 */
	public CashCard getCard()
	{
		return card;
	}
	
	/**
	 * Get balance from account
	 * @return balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Get the name of owner
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
}

