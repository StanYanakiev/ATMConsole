/** 
 * @author Stanislav Yanakiev
 * 
 * MyATM
 * 
 * All Rights Reserved to Author
 */

/**
 * Tester that creates two banks, adds accounts to the banks.
 * Creates two ATMs associated with each bank.
 * Starts the ATM authorization process and completes a transaction if satisfies requirements
 */
public class ATMSystem 
{
	public static void main(String args[])
	{
		//Creation of two Banks
		Bank BoA = new Bank(9408);
		Bank Fargo = new Bank(4001);
		
		//Creation of Bank Accounts
		BankAccount tracer = new BankAccount(9408, 32505, 150, "Ab08i", "Tracer");
		BankAccount sombra = new BankAccount(9408, 48204, 700, "RoXi", "Sombra");
		BankAccount rein = new BankAccount(9408, 76412, 160, "FireStrike", "Rein");
		BankAccount orisa = new BankAccount(9408, 23542, 1500, "Shield20", "Orisa");
		orisa.getCard().setExpDateYear(-10);
		
		BankAccount symm = new BankAccount(4001, 35243, 0, "TelePort1", "Symm");
		BankAccount zen = new BankAccount(4001, 18372, 200, "Orb100", "Zen");
		BankAccount mercy = new BankAccount(4001, 23465, 235, "RIP5xRess", "Mercy");
		BankAccount anna = new BankAccount(4001, 98564, 600, "0Accuracy", "Anna");
		BankAccount lucio = new BankAccount(4001, 54292, 330, "Boostio", "Anna");
		
		//Adding Accounts to Bank A
		BoA.getList().add(tracer);
		BoA.getList().add(sombra);
		BoA.getList().add(rein);
		BoA.getList().add(orisa);
		
		//Adding Accounts to Bank B
		Fargo.getList().add(symm);
		Fargo.getList().add(zen);
		Fargo.getList().add(mercy);
		Fargo.getList().add(anna);
		Fargo.getList().add(lucio);
		
		//The State of The Banks
		System.out.println("The States Of The Two Banks\n");
		System.out.println(BoA.bankState());
		System.out.println("\n");
		System.out.println(Fargo.bankState());
		
		//Creation ATMs for Bank1
		ATM ATM1A = new ATM(BoA);
		ATM ATM2A = new ATM(BoA);
		
		//Creation ATMs for Bank2
		ATM ATM1B = new ATM(Fargo);
		ATM ATM2B = new ATM(Fargo);
		
		//The State of The ATM
		System.out.println("States of four ATMs (2 for each Bank)\n");
		System.out.println(ATM1A.ATMState());
		System.out.println(ATM2A.ATMState());
		
		System.out.println("\n");
		
		System.out.println(ATM1B.ATMState());
		System.out.println(ATM2B.ATMState());
		
		//Start of ATM User Interaction
		System.out.println("\n~~~Welcome~~~"); 
		ATM1A.readCardNumber();
	
	}
}

