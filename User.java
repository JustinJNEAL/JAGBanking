
public class User {
	private String name;
	private Account userAccount;
	
	// Constructor for user account
	User(String name, Account userAccount) {
		this.name = name;
		this.userAccount = userAccount;
		
	}
	
	// Getter for account
	public Account getAccount() {
		return userAccount;
	}

	
//  TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING TOSTRING
	@Override
	public String toString() {
		return "\nAbout User\n----------\n" +
				"Account holder name: " + name +
				"\n" + userAccount;
	}

	
}