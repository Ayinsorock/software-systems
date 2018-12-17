package ss.week2.test;

import org.junit.*;
import ss.week2.hotel.Password;
import ss.week2.hotel.Safe;

public class SafeTest {
	private Safe safe;
	private final String PASSWORD = "123456";


	@Before
	public void setUp () {
		this.safe = new Safe();
	}

	@Test
	public void testInitiate () {
		Assert.assertFalse(this.safe.isOpen());
		Assert.assertFalse(this.safe.isActive());
	}

	@Test
	public void testActivateAndOpenSafe () {
		this.safe.activate(PASSWORD);
		Assert.assertTrue(this.safe.isActive());

		this.safe.open(PASSWORD);
		Assert.assertTrue(this.safe.isOpen());
	}

	@Test
	public void testPasswordObject () {
		Password password = this.safe.getPassword();

		Assert.assertTrue(password.testWord(this.PASSWORD));
	}
}
