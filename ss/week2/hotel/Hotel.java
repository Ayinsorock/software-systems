package ss.week2.hotel;

/**
 * P-2.15
 */
public class Hotel {
	private Room room1;
	private Room room2;
	private String name;
	private Password password;


	/**
	 * Construct the Hotel object with a given name
	 *
	 * @param name name of the Hotel
	 */
	public Hotel (String name) {
		this.name = name;
		this.password = new Password();
		this.room1 = new Room(101);
		this.room2 = new Room(102);
	}

	/**
	 *
	 * @param password password for checking guests into rooms
	 * @param guest name of the guest we're trying to check-in
	 */
	public Room checkIn (String password, String guest) {
		Guest guest1 = this.room1.getGuest();
		Guest guest2 = this.room2.getGuest();

		// Password is incorrect
		if (!this.password.testWord(password)) {
			return null;
		}

		 // Guest with given name already exists
		if ((guest1 != null && guest1.getName().equals(guest)) || (guest2 != null && guest2.getName().equals(guest))) {
			return null;
		}

		if (guest1 == null) {
			(new Guest(guest)).checkin(this.room1);
			return this.room1;
		}

		if (guest2 == null) {
			(new Guest(guest)).checkin(this.room2);
			return this.room2;
		}

		 // There are no rooms available
		return null;
	}

	/**
	 * Check a guest out of his/her room
	 *
	 * @param guest name of the guest we want to check out
	 */
	public void checkOut (String guest) {
		if(this.room1.getGuest() != null && this.room1.getGuest().getName().equals(guest)) {
			this.room1.getGuest().checkout();
		}

		if(this.room2.getGuest() != null && this.room2.getGuest().getName().equals(guest)) {
			this.room2.getGuest().checkout();
		}
	}

	/**
	 *
	 * @return A Room object if one is available. None if the hotel is full
	 */
	public Room getFreeRoom () {
		if(this.room1.getGuest() == null) {
			return this.room1;
		}

		if(this.room2.getGuest() == null) {
			return this.room2;
		}

		 // There are no rooms available
		return null;
	}

	/**
	 * @param guest The name of the guest we are looking for
	 * @return The Room the guest is checked into. Null if the guest can not be found.
	 */
	public Room getRoom (String guest) {
		if (this.room1.getGuest() != null && this.room1.getGuest().getName().equals(guest)) {
			return this.room1;
		}

		if(this.room2.getGuest() != null && this.room2.getGuest().getName().equals(guest)) {
			return this.room2;
		}

		return null;
	}

	/**
	 * @return password object protecting the Hotel
	 */
	public Password getPassword() {
		return this.password;
	}

	/**
	 * Convert information on the Hotel to a String
	 *
	 * @return String  containing Hotel info
	 */
	public String toString() {
		String humanReadable = "======== " + this.name + " ========\n\n";

		if (this.room1.getGuest() != null) {
			humanReadable += "Room1: " + this.room1.getGuest().toString() + "\n";
		}

		if (this.room2.getGuest() != null) {
			humanReadable +=  "Room2: " + this.room2.getGuest().toString() + "\n";
		}

		System.out.print(humanReadable);
		System.out.flush();

		return humanReadable;
	}
}
