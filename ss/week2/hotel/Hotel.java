package ss.week2.hotel;

public class Hotel {
	private Room room1;
	private Room room2;
	private String name;
	private Password password;


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
	 * @return
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
	 *
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
	 *
	 * @return
	 */
	public Password getPassword() {
		return this.password;
	}

	public String toString() {
		String humanReadable = "======== " + this.name + " ========\n\n";

		if (this.room1.getGuest() != null) {
			humanReadable =
					humanReadable + "Room1: " + this.room1.getGuest().toString() + "\n";
		}

		if (this.room2.getGuest() != null) {
			humanReadable =
					humanReadable +  "Room2: " + this.room2.getGuest().toString() + "\n";
		}

		humanReadable += "\n===============================";

		System.out.print(humanReadable);
		System.out.flush();

		return humanReadable;
	}
}
