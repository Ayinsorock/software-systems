package ss.week3.pw;

public class BasicChecker implements Checker {
	@Override
	public boolean acceptable(String phrase) {
		return phrase.length() >= 6 && !phrase.contains(" ");
	}

	@Override
	public String generatePassword() {
		return "sdODcoxOOocc";
	}
}
