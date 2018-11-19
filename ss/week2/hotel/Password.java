package ss.week2.hotel;

public class Password {
	public static final String INITIAL = "HorseBatteryStaple";
	private String password;

	public Password () {
		this.password = Password.INITIAL;
	}

	public static boolean ACCEPTABLE (String suggestion) {
		return suggestion.length() > 5 && !suggestion.contains(" ");
	}

	public boolean testWord (String test) {
		return test.equals(this.password);
	}

	public boolean setWord(String oldPass, String newPass) {
		if(!oldPass.equals(this.password) || !ACCEPTABLE(newPass)) {
			return false;
		}

		this.password = newPass;
		return true;
	}
}
