// Import random library
import java.util.Random;

public class Account {
	private double balance;
	private int pin;
	private int accountNumber;
	
	// All account numbers will be 6 digits
	// Initialize upper bound for account number
	private final int UPPER = 1000000;
	// Initialize lower bound for account number
	private final int LOWER = 100000;
	
	// Account constructor
	Account() {
		Random rd = new Random();
		accountNumber = rd.nextInt(UPPER - LOWER) + LOWER;
		
	}
	
	// Getter for balance
	public double getBalance() {
		return balance;
	}
	
	// Getter for account number
	public int getAccountNumber() {
		return accountNumber;
	}
	
	// Getter for pin
	public int getPIN() {
		return pin;
	}
	
	// Setter for balance
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	// Setter for PIN
	public void setPIN(int pin) {
		this.pin = pin;
	}
	
// WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL WITHDRAWAL
	// Method to withdrawal funds from account
	public void withdrawal(double funds) {
		if (funds > balance) System.out.println("Error: Insufficient funds.");
		else {
			balance -= funds;
			System.out.println("Here's your $" + funds);
			System.out.println("Your new balance is: $" + balance + ", have a nice day!");
		}
		
	}
	
// DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT
	// Method to deposit funds into account
	public void deposit(double funds) {
		if (funds < 0) System.out.println("Is this some sort of a joke?");
		else if (funds >= 1000) {
			System.out.println("Hmmm... I smell dirty money.");
			balance += funds;
			System.out.println("That $" + funds + " was delicous!");
			System.out.println("Your new balance is: $" + balance + ", have a nice day!\n");
		} else {
			balance += funds;
			System.out.println("That $" + funds + " was delicous!");
			System.out.println("Your new balance is: $" + balance + ", have a nice day!\n");
		}
		
	}
	

}
