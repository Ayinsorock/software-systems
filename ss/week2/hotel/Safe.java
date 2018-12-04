package ss.week2.hotel;


/**
 * P-2.8
 *
 * Safe class implementing a safe which can be opened and closed with a password
 */
public class Safe {
	protected boolean active;
	protected boolean open;
	protected Password password;

	public static void main (String[] args) {
		Safe safe  = new Safe();
	}

	/**
	 * @requires Password.ACCEPTABLE(password)
	 *
	 * @ensures this.password.test(password)
	 *          !this.active
	 *          !this.open
	 */
	public Safe () {
		this.password = new Password();
		this.active = false;
		this.open = false;
	}

	/**
	 *
	 * @param password password to be tested
	 * @return boolean indicating if the action was successful
	 *
	 * @ensures \result == this.active
	 */
	public boolean activate (String password) {
		if (this.password.testWord(password)) {
			this.active = true;
			return true;
		}

		return false;
	}

	/**
	 * @ensures this.active == false
	 *          this.open == false
	 */
	public void deactivate () {
		this.active = false;
		this.open = false;
	}

	/**
	 * @ensures \result == this.open
	 */
	public boolean open (String password) {
		if (this.password.testWord(password)) {
			this.open = true;
			return true;
		}

		return false;
	}

	/**
	 * @ensures \result == this.active
	 */
	public boolean isActive () {
		return this.active;
	}

	/**
	 * @ensures \result == this.open
	 */
	public boolean isOpen (){
		return this.open;
	}

	/**
	 * @ensures \result == this.password
	 */
	public Password getPassword() {
		return this.password;
	}
}
