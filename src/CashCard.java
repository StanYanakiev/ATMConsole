/** 
 * @author Stanislav Yanakiev
 * 
 * MyATM
 * 
 * All Rights Reserved to Author
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar; 

/**
 * CashCard with accountNumber, expiration date, password
 */
public class CashCard implements Comparable<CashCard>
{
	private String cardNumber;
	private int cardNumberInt;
	private String password;
	private GregorianCalendar expDate;
	private ArrayList<String> cardTransactions;
	
	/**
	 * Constructs a CashCard
	 * @param cnum Card Number consisted of bankID and accountNumber
	 * @param anExpDate when the card becomes invalid
	 * @param pw used to be able to do transactions at ATMs
	 */
	public CashCard(String cnum, GregorianCalendar anExpDate, String pw)
	{
		cardNumber = cnum;
		password = pw;
		expDate = anExpDate;
		cardNumberInt = Integer.parseInt(cardNumber);
		cardTransactions = new ArrayList<String>();
	}
	
	/**
	 * Gets the cardNumber as a string
	 * @return cardNumber as a string
	 */
	public String getCardNumber()
	{
		return cardNumber;
	}
	
	/**
	 * Gets the cardNuber as an int
	 * @return cardNumber as an int
	 */
	public int getCardNumberInt()
	{
		return cardNumberInt;
	}
	
	/**
	 * Sets a new card number
	 * @param cnum
	 */
	public void setCardNumber(String cnum)
	{
		cardNumber = cnum;
	}
	
	/**
	 * gets the expiration date
	 * @return expDate
	 */
	public GregorianCalendar getExpDate()
	{
		return expDate;
	}
	
	/**
	 * sets a new expiration date
	 * @param yearsFromToday
	 */
	public void setExpDateYear(int yearsFromToday)
	{
		expDate.add(Calendar.YEAR, yearsFromToday);
	}
	
	/**
	 * gets the password
	 * @return password
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * Sets a new password
	 * @param pw
	 */
	public void setPassword(String pw)
	{
		password = pw;
	}
	
	/**
	 * Checks if the cash card is expired
	 * @return true if card is expired, false if the card is still valid
	 */
	public boolean isExpired()
	{
		GregorianCalendar today = new GregorianCalendar();
		if (expDate.before(today))
		{
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Adds a transaction to the Transaction History
	 * @param amount
	 */
	public void addTransaction(int amount)
	{
		cardTransactions.add("$" + amount + "Withdrawn");
	}
	
	/**
	 * Checks if this card is equal to another card
	 * 
	 * return true if equal; false otherwise 
	 */
	public boolean equals(Object o)
	{
		CashCard x = (CashCard) o;
		return this.compareTo(x) == 0;
	}
	

	/**
	 * Compares one card to the other. 
	 * 
	 * return negative number if this is less; positive if this is more; 0 if equal
	 */
	@Override
	public int compareTo(CashCard o)
	{
		
		int cardNum1 = this.cardNumberInt - o.cardNumberInt;
		return cardNum1;
	}
	
	
	/**
	 * Get the expiration date as a string representation
	 * 
	 * @return expiration date
	 */
	public String getStringOfExpiryDate() {
		String year = Integer.toString(expDate.get(Calendar.YEAR));
		String month = Integer.toString(expDate.get(Calendar.MONTH) +1);
		String day = Integer.toString(expDate.get(Calendar.DAY_OF_MONTH));
		return month + "/" + day + "/" + year;
	}
}
