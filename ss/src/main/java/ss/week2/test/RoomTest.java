package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;

public class RoomTest {
	private Guest guest;
	private Room room;

	@Before
	public void setUp() {
		guest = new Guest("Jip");
		// TODO: initialise the variable room
	}

	@Test
	public void testSetUp() {
		assertEquals(101, room.getNumber());
	}

	@Test
	public void testSetGuest() {
		room.setGuest(guest);
		assertEquals(guest, room.getGuest());
	}

}
