
public class Checking extends Account {
	private static String type = "Checking";
	
	// Constructor for checking account
	Checking(double deposit, int pin) {
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