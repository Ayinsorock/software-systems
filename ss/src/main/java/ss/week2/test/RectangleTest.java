package ss.week2.test;

import org.junit.Before;
import org.junit.Test;
import ss.week2.Rectangle;

import static org.junit.Assert.assertEquals;


/**
 * P-2.5
 */
public class RectangleTest {
	/** Test variable for <tt>Rectangle</tt>-object */
 	private Rectangle rectangle;

	@Before
	public void setUp() {
		rectangle = new Rectangle(20, 30);
	}

	@Test
	public void testConstructor() {
		assertEquals(20, rectangle.width());
		assertEquals(30, rectangle.length());
	}

	@Test
	public void testQueries() {
		assertEquals(100, rectangle.perimiter());
		assertEquals(600, rectangle.area());
	}
}
