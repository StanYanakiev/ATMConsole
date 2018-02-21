/** 
 * @author Stanislav Yanakiev
 * 
 * MyATM
 * 
 * All Rights Reserved to Author
 */

import java.util.Scanner;

/**
 *ATM that checks authorization, verification and transaction processes
 */
public class ATM 
{
	private final int MAX_AMOUNT = 400;
	private Bank bankID;
	private CashCard insertedCard;

	
	Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructs an ATM with a bankID
	 * @param id
	 */
	public ATM(Bank id)
	{
		bankID = id;
	}
	
	/**
	 * Reads a card number and checks if it is associated with the correct bank
	 */
	public void readCardNumber()
	{
		// Asks The User for Card Number
		System.out.println("Enter Card Number");
		String input = sc.nextLine();
		//Parse the card number to Integer
		int inputInt = Integer.parseInt(input);
		
		
		if (bankID.verifyExistance(inputInt) == true)
		{
			insertedCard = bankID.getACashCard();
		
		
			String bankStringID = insertedCard.getCardNumber().substring(0, 4);
			int bankIntID = Integer.parseInt(bankStringID);
			if( bankIntID == bankID.getBankID())
			{
				System.out.println("Card Read");
				verifyCardInBank();
			}
		}
		else 
		{
			System.out.println("The Bank ID the card is associated with is invalid. "
										+ "Please choose another card.");
			readCardNumber();
		}
	}
	
	/**
	 * Checks if the card us registered in the bank and has an existing BankAccount
	 * If so the expiration date is checked, else card is returned
	 */
	public void verifyCardInBank()
	{
		if(bankID.verifyExistance(insertedCard.getCardNumberInt()) == true)
		{
			checkExpDate();
		}
		else
		{
			System.out.println("Card is not Associated With this Account");
			System.out.println("Card Returned. Try Again With Another Card");
			readCardNumber();
		}
	}
	
	/**
	 * Checks if the card is expired. If not, it proceeds to verifyPassword
	 */
	public void checkExpDate()
	{
		if(insertedCard.isExpired() == false)
		{
			System.out.println("Valid Card");
			verifyPassword();
		}
		else
		{
			System.out.println("Card Rejected. The Card Has Expired.");
			System.out.println("Please Try Another Card");
			insertedCard = null;
			readCardNumber();
		}
	}
	
	/**
	 * Checks if the password is correct
	 * If so the transaction starts
	 */
	public void verifyPassword()
	{
		System.out.println("Please Enter Your Password: ");
		String input = "";
		input = sc.nextLine();
		if(input.equals(insertedCard.getPassword()))
		{
			System.out.println("Success");
			transactionStart();
		}
		else
		{
			System.out.println("Password Incorrect");
			verifyPassword(); 
		}
		
	}
	
	/**
	 * User is asked for an amount to withdraw
	 * Checks if the amount exceeds the daily ATM maximum
	 * Checks if the amount exceeds the balance in bankAccount
	 * If not, the amount is withdrawn from the bankAccount in Bank
	 */
	public void transactionStart()
	{
		System.out.println("Enter An Amount To Withdraw:");
		int input = sc.nextInt();
		
		//Check if the amount wished to withdraw is in the range of the daily maximum
		while(input > MAX_AMOUNT)
		{
			System.out.println("Amount Exceeds The Transaction Maximum ");
			System.out.println("Enter Amount Again: ");
			input = sc.nextInt();
			
		}
		
		// Checks if there is enough balance to withdraw from the BankAccount
		BankAccount bankAccount = bankID.getABankAccount();
		while (input > bankAccount.getBalance())
		{
			System.out.println("Not Enough Suffiecnt Balance In Account");
			System.out.println("Enter Amount again: ");
			input = sc.nextInt();
			
		}
		bankAccount.moneyWithdrawn(input);
		System.out.println("$" + input + " Has Been Successfully Withdrawn");
		System.out.println("$" + bankAccount.getBalance() + " Left In Balance \nTransaction Logged");
		System.out.println("Card Returned - Take Money");
	}
	
	/**
	 * A string that consists of the state of the ATM
	 * @return state
	 */
	public String ATMState()
	{
		String state = "";
		state += "ATM for: BankID " + bankID.getBankID() + "\n";
		state += "The maximum amount of cash a card can withdraw per day: $" + MAX_AMOUNT;
		return state;
	}
}
