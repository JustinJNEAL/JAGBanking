/*
 * 
 * This project is a collaborative effort by
 * Justin Neal, Angel Amadi, and Gabriel Montero
 * 
 */

// Import scanner library
import java.util.Scanner;

public class Source {
	static Scanner sc = new Scanner(System.in);
	static Bank bank = new Bank();

	
// MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN MAIN
	public static void main(String[] args) {
		boolean exit = false;
		
		// Run menu sequence
		while (!exit) {
			System.out.println("  ------------------------------------------------");
			System.out.println(" /                                                \\");
			System.out.println("|                                                  |");
			System.out.println("|              -----------------------             |");
			System.out.println("|              Welcome to JAG Banking!             |");
			System.out.println("|              -----------------------             |");
			System.out.println("|                                                  |");
			System.out.println("|             Please select a menu item            |");
			System.out.println("|             ~~~~~~~~~~~~~~~~~~~~~~~~~            |");
			System.out.println("|             1. Make a deposit                    |");
			System.out.println("|             2. Make a withdrawal                 |");
			System.out.println("|             3. View account balance              |");
			System.out.println("|             4. Create new account                |");
			System.out.println("|             5. Close current account             |");
			System.out.println("|             0. Exit                              |");
			System.out.println("|                                                  |");
			System.out.println(" \\                                                /");
			System.out.println("  ------------------------------------------------");
			System.out.println();
			
			System.out.print("Make your selection: ");
			int selection = getUserSelection();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			
			switch (selection) {
				// Make deposit
				case 1:
					makeDeposit();
					break;
				
				// Make withdrawal
				case 2:
					makeWithdrawal();
					break;
					
				// View balance
				case 3:
					viewBalance();
					break;
					
				// Create account
				case 4:
					createAccount();
					break;
					
				// Close account
				case 5:
					closeAccount();
					break;
					
				// Exit sequence
				case 0:
					System.out.println("Goodbye!");
					System.exit(selection);
					break;
					
				// Default. Print error
				default:
					System.out.println("Error: System error has occured");
			}
		}
		


	}
	

// GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION GETUSERSELECTION
	// Method that gets user selection
	private static int getUserSelection() {
		// Set selection to non-essential value
		int selection = -1;
		
		// Do while loop to run sequence even after user error
		do {
			// try catch block to make sure user input is numbers only
			try {
				selection = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error: Selection should be numbers only");
			}
			// If block to catch error for out of range values
			if (selection > 5 || selection < 0) System.out.println("Error: selection not available");
		} while (selection > 5 || selection < 0);
		
		return selection;
	}

	
// DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT DEPOSIT
	// Method that allows user to make deposits	
	private static void makeDeposit() {
			// Set default variables
			double funds = 0;
			int accountNumber = 0, pin = 0;
			boolean exit = false;
			
			System.out.println("+-----------------------------------------------------------------+");
			System.out.println("|                  Welcome back to JAG Banking!                   |");
			System.out.println("|                                                                 |");
			System.out.println("|                We offer fast and easy deposits.                 |");
			System.out.println("+-----------------------------------------------------------------+");
			
			// Prompt for deposit amount
			System.out.print("\nEnter your deposit amount: ");
			// Do while loop, keeps running until correct input
			do {
				// Get user input for funds
				funds = Double.parseDouble(sc.nextLine());
				// Checks for positive funds
				if (funds > 0) exit = true;
				else System.out.println("Error: Minimum deposit of $1 required");
			} while (!exit);
			
			// Reset boolean variable
			exit = false;
			do {
				// Get user input for account number
				System.out.print("\nEnter your account number: ");
				try {
					accountNumber = Integer.parseInt(sc.nextLine());
					System.out.println();
				} catch (NumberFormatException e) {
					System.out.println("Error: Account number should contain only numbers");
				}
				
				// Check for 6 digit account number
				if (!Integer.toString(accountNumber).matches("\\d{6}")) System.out.println("Sorry, our account numbers are 6 digits. Please try again.\n");
				else {
					// Checks for existing account
					if (bank.containsKey((Integer)accountNumber)) {
						// Prompt user input and collect PIN
						System.out.print("Enter PIN: ");
						try {
							pin = Integer.parseInt(sc.nextLine());
							System.out.println();
						} catch (NumberFormatException e) {
							System.out.println("Error: PIN should contain numbers only");
						}
							
						// Check PIN for the associated account
						if (pin == bank.getUser((Integer)accountNumber).getAccount().getPIN()) {
							// Deposit funds into user account
							bank.getUser((Integer)accountNumber).getAccount().deposit(funds);
							exit = true;
						} else System.out.println("Error: PIN invalid");

					} else System.out.println("Error: Account does not exist");
				}	
			} while (!exit);
			
		}
		
		
// MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL MAKEWITHDRAWAL
		// Method that allows user to withdrawal money
		private static void makeWithdrawal() {
			int accountNumber = 0, pin = 0;
			double funds = 0;
			boolean exit = false;
			
			System.out.println("+-------------------------------------------------------------------+");
			System.out.println("|                    Welcome back to JAG Banking!                   |");
			System.out.println("|                                                                   |");
			System.out.println("|             We offer safe and hassle-free withdrawls.             |");
			System.out.println("+-------------------------------------------------------------------+");
			
			System.out.print("\nEnter your withdrawal amount: ");
			do {
				try {
					funds = Double.parseDouble(sc.nextLine());
					if (funds > 0) exit = true;
					else System.out.println("Error: Minimum withdrawal of $1 required");
				} catch (NumberFormatException e) {
					System.out.println("Error: Withdrawal amount should contain only numbers");
				}
			} while (!exit);
			
			exit = false;
			do {
				System.out.println("\nEnter your account number: ");
				try {
					accountNumber = Integer.parseInt(sc.nextLine());
					System.out.println();
				} catch (NumberFormatException e) {
					System.out.println("Error: Account number should contain only numbers");
				}
				
				if(!Integer.toString(accountNumber).matches("\\d{6}")) System.out.println("Sorry, our account numbers are 6 digits. Please try again.\n");
				else {
					if (bank.containsKey((Integer)accountNumber)) {
						System.out.print("Enter PIN: ");
						try {
							pin = Integer.parseInt(sc.nextLine());
							System.out.println();
						} catch (NumberFormatException e) {
							System.out.println("Error: PIN should contain numbers only");
						}
						
						if (pin == bank.getUser((Integer)accountNumber).getAccount().getPIN()) {
							bank.getUser((Integer)accountNumber).getAccount().withdrawal(funds);
							exit = true;
						} else System.out.println("Error: PIN invalid");
					} else System.out.println("Error: Account does not exist");
				}
			} while (!exit);
			
		}
		
		
// VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE VIEWBALANCE
		// View account balance
		private static void viewBalance() {
			boolean exit = false;
			int accountNumber = 0, pin = 0;
			double balance = 0;
			do {
				// Get user input for account number
				System.out.print("\nEnter your account number: ");
				try {
					accountNumber = Integer.parseInt(sc.nextLine());
					System.out.println();
				} catch (NumberFormatException e) {
					System.out.println("Error: Account number should contain only numbers");
				}
				
				// Check for 6 digit account number
				if (!Integer.toString(accountNumber).matches("\\d{6}")) System.out.println("Sorry, our account numbers are 6 digits. Please try again.\n");
				else {
					// Checks for existing account
					if (bank.containsKey((Integer)accountNumber)) {
						// Prompt user input and collect PIN
						System.out.print("Enter PIN: ");
						try {
							pin = Integer.parseInt(sc.nextLine());
							System.out.println();
						} catch (NumberFormatException e) {
							System.out.println("Error: PIN should contain numbers only");
						}
							
						// Check PIN for the associated account
						if (pin == bank.getUser((Integer)accountNumber).getAccount().getPIN()) {
							// Deposit funds into user account
							balance = bank.getUser((Integer)accountNumber).getAccount().getBalance();
							exit = true;
						} else System.out.println("Error: PIN invalid");

					} else System.out.println("Error: Account does not exist");
				}	
			} while (!exit);
			System.out.println("\nYour current balance is $" + balance);
			
		}
	
		
// CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT CREATEACCOUNT
		// Create user account
		private static void createAccount() {
			String name, type;
			int pin = 0;
			double deposit = 0;
			boolean exit = false;
		
			System.out.println("+-----------------------------------------------------------------+");
			System.out.println("|          Thank you for your interest in JAG Banking!            |");
			System.out.println("|                                                                 |");
			System.out.println("|             We offer checking and savings accounts.             |");
			System.out.println("|                      ~~~~~~~~     ~~~~~~~                       |");
			System.out.println("|  All accounts must be created with an initial deposit of $100.  |");
			System.out.println("+-----------------------------------------------------------------+");
			System.out.println();
			System.out.println();

			// Prompt and store user's preferred account type
			do {
				System.out.print("Enter the type of account you would like to open: ");
				type = sc.nextLine();
				System.out.println();
				if (type.equalsIgnoreCase("checking") || type.equalsIgnoreCase("savings")) exit = true;
				else System.out.println("Sorry, that account type is currently not available. Please try again.\n");	
			} while (!exit);
		
		
			// Get account holder's name
			System.out.print("Enter your name: ");
			name = sc.nextLine().toLowerCase();
			System.out.println();
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
		
			exit = false;
			// Get user's PIN
			do {
				System.out.print("Enter your desired four digit PIN: ");
				try {
					pin = Integer.parseInt(sc.nextLine());
					System.out.println();				
					if (!Integer.toString(pin).matches("\\d{4}+")) System.out.println("Sorry, your PIN must be four digits. Please try again.\n");
					else exit = true;
				} catch (NumberFormatException e) {
					System.out.println("Error: You PIN must contain numbers only");
				}
				
			} while (!exit);
		
			exit = false;
			// Get user's initial deposit
			do {
				System.out.print("Enter the amount of money you would like to deposit today: ");
				try {
					deposit = Double.parseDouble(sc.nextLine());
					System.out.println();
				} catch (NumberFormatException e) {
					System.out.println("Error: Deposits should be numbers only");
				}
			
				if (deposit < 100) System.out.println("Sorry, a minimum of $100 is required to open an account.\n");
				else exit = true;
			} while (!exit);
		
			// Create instance of account
			Account account;
			System.out.println("Account created. Thanks for joining us!\n");
			// Set account equal to checking or savings
			if (type.equalsIgnoreCase("checking")) {
				account = new Checking(deposit, pin);
			} else account = new Savings(deposit, pin);
		
			// Create instance of user
			User user = new User(name, account);
			// Add new user to list of accounts
			bank.addUser(user);

			// Print account details
			System.out.println("Account Details\n---------------\nAccount holder name: " + name + "\nAccount Type: " + type.substring(0, 1).toUpperCase() + type.substring(1) + "\nAccount Number: " + account.getAccountNumber() + "\nBalance: " + deposit + "\n");
			
		}
		
		
// CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT CLOSEACCOUNT		
		// Close user account
		private static void closeAccount() {
			int accountNumber = 0, pin = 0;
			boolean exit = false;
			do {
				// Get user input for account number
				System.out.print("\nEnter your account number: ");
				try {
					accountNumber = Integer.parseInt(sc.nextLine());
					System.out.println();
				} catch (NumberFormatException e) {
					System.out.println("Error: Account number should contain only numbers");
				}
				
				// Check for 6 digit account number
				if (!Integer.toString(accountNumber).matches("\\d{6}")) System.out.println("Sorry, our account numbers are 6 digits. Please try again.\n");
				else {
					// Checks for existing account
					if (bank.containsKey((Integer)accountNumber)) {
						// Prompt user input and collect PIN
						System.out.print("Enter PIN: ");
						try {
							pin = Integer.parseInt(sc.nextLine());
							System.out.println();
						} catch (NumberFormatException e) {
							System.out.println("Error: PIN should contain numbers only");
						}
							
						// Check PIN for the associated account
						if (pin == bank.getUser((Integer)accountNumber).getAccount().getPIN()) {
							// Deposit funds into user account
							bank.removeUser((Integer)accountNumber);
							exit = true;
						} else System.out.println("Error: PIN invalid");

					} else System.out.println("Error: Account does not exist");
				}	
			} while (!exit);
			System.out.println("We're sad to see you go :'(");
		}


}


