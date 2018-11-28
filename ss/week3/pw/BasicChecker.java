package ss.week3.pw;

public class BasicChecker implements Checker {
	public static final String INITPASS = "helloworld1234";

	@Override
	public boolean acceptable(String phrase) {
		return phrase.length() >= 6 && !phrase.contains(" ");
	}

	@Override
	public String generatePassword() {
		return INITPASS;
	}
}
