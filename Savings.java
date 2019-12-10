
public class Savings extends Account {
	private static String type = "Savings";
	
	// Constructor for savings account
	Savings(double deposit, int pin) {
		super();
		this.setBalance(deposit);
		this.setPIN(pin);
	}
	

// TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING
	@Override
	public String toString() {
		return "Account Type: " + type + 
				"\nAccount Number: " + this.getAccountNumber() + 
				"\nBalance: " + this.getBalance();
	}
	

}