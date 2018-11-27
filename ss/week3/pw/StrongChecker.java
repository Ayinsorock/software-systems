package ss.week3.pw;

public class StrongChecker implements Checker {
	@Override
	public boolean acceptable(String phrase) {
		char last = phrase.charAt(phrase.length() - 1);
		char first = phrase.charAt(0);

		return !Character.isDigit(first) && Character.isDigit(last) && phrase.length() > 6;
	}

	@Override
	public String generatePassword() {
		return "Hallo12345678";
	}
}