package ss.week3.pw;

import ss.week3.pw.Checker;
import ss.week3.pw.StrongChecker;

public class Password {
	private Checker checker;
	private String factoryPassword;
	private String password;

	public Password () {
		this(new StrongChecker());
	}

	public Password (Checker checker) {
		this.checker = checker;
		this.password = checker.generatePassword();
	}

	public static boolean ACCEPTABLE (String suggestion) {
		return suggestion.length() > 5 && !suggestion.contains(" ");
	}

	public boolean testWord (String test) {
		return test.equals(this.password);
	}

	public boolean setWord(String oldPass, String newPass) {
		if (!oldPass.equals(this.password) || !ACCEPTABLE(newPass)) {
			return false;
		}

		this.password = newPass;
		return true;
	}

	public Checker checker() {
		return this.checker;
	}

	public String factoryPassword() {
		return this.factoryPassword;
	}
}
