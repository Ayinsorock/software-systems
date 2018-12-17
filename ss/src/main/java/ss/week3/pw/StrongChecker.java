package ss.week3.pw;

public class StrongChecker extends BasicChecker {
	public static void main (String[] args) {
		StrongChecker myChecker = new StrongChecker();

		System.out.println(myChecker.generatePassword());
	}

	@Override
	public boolean acceptable(String phrase) {
		char last = phrase.charAt(phrase.length() - 1);
		char first = phrase.charAt(0);

		return !Character.isDigit(first) && Character.isDigit(last) && super.acceptable(phrase);
	}

	@Override
	public String generatePassword() {
		StringBuffer example = new StringBuffer();

		for (int i = 0; i < 10; i++) {
			example.append(Character.toString(this.randomChar()));
		}

		return example.toString();
	}

	private char randomChar() {
		return (char)((int) (Math.random() * 26) + 65 + (Math.random() > 0.5 ? 32 : 0));
	}
}