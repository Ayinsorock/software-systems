package ss.week3.pw;

public class TimedPassword extends Password {
	private long validTime;
	private static final long DEFAULT_TIME_IN_MILLI_SECONDS = 1000 * 60 * 60 * 24; // 1 day

	public TimedPassword (Checker checker, long validTime) {
		super(checker);

		this.validTime = System.currentTimeMillis() + validTime * 1000;
	}

	public TimedPassword(Checker checker) {
		this(checker, System.currentTimeMillis() + DEFAULT_TIME_IN_MILLI_SECONDS);
	}

	public TimedPassword (long validTime) {
		this(new BasicChecker(), validTime);
	}

	public TimedPassword() {
		this(new BasicChecker());
	}

	@Override
	public boolean setWord(String oldPass, String newPass){
		boolean succeeded = super.setWord(oldPass, newPass);

		if (succeeded) {
			this.validTime = System.currentTimeMillis() + DEFAULT_TIME_IN_MILLI_SECONDS;
		}

		System.out.println(succeeded);

		return succeeded;
	}

	public boolean isExpired () {
		System.out.println(validTime);
		System.out.println(System.currentTimeMillis());

		return this.validTime - System.currentTimeMillis() < 0;
	}


}
