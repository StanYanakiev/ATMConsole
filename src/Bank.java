/** 
 * @author Stanislav Yanakiev
 * 
 * MyATM
 * 
 * All Rights Reserved to Author
 */
import java.util.ArrayList;

/**
 * Creates a bank that stores BankAccounts in an arrayList
 */
public class Bank 
{

	private int bankID;
	private  ArrayList<BankAccount> bankList;
	private BankAccount aBankAccount;
	private CashCard aCashCard;
	
	/**
	 * Creates a Bank with an ID
	 * @param id
	 */
	public Bank(int id) 
	{
		bankID = id;
		bankList = new ArrayList<>();
		
	}
	
	/**
	 * Gets the arrayList consisting of BankAccounts
	 * @return bankList
	 */
	public ArrayList<BankAccount> getList()
	{
		return bankList;
	}
	
	/**
	 * Gets the BankID
	 * @return bankID;
	 */
	public int getBankID()
	{
		return bankID;
	}
	
	/**
	 * Gets a specified Bank Account
	 * @return aBankAccount
	 */
	public BankAccount getABankAccount()
	{
		return aBankAccount;
	}
	
	/**
	 * Gets a cash card
	 * @return aCashCard
	 */
	public CashCard getACashCard()
	{
		return aCashCard;
	}
	
	/**
	 * Verifies if the CashCard Number is registered and existing in the arrayList of BankAccounts in the Bank
	 * @param cardNumberInt
	 * @return true if exists, false if not
	 */
	public boolean verifyExistance(int cardNumberInt)
	{
		if (!bankList.isEmpty())
		{
			for (int i = 0; i < bankList.size() ; i++)
			{
				if (bankList.get(i).getCard().getCardNumberInt() == cardNumberInt) 
				{
					aBankAccount = bankList.get(i);
					aCashCard = bankList.get(i).getCard();
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * A string that consists of the state of the Bank
	 * @return state
	 */
	public String bankState()
	{
		String state = "";
		if(bankList.isEmpty())
		{
			return "(no customers)";
		}
		int custNum = bankList.size();
		state += "(" + custNum + " customers)\n";
		for(int i = 0; i < bankList.size(); i++) 
		{
			state += bankList.get(i).getName()+" with Cash Card (bankid: " + bankID + ", account number: " + bankList.get(i).getAccountID() + ", expires on: " + bankList.get(i).getCard().getStringOfExpiryDate() + ") \n";
		}
		return state;
	}
}
