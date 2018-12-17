package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ss.week2.LampSetting;
import ss.week2.ThreeWayLamp;

/**
 * P-2.7
 *
 * Test program for ThreeWaylamp
 * @author Gerjan Wielink
 */
public class ThreeWayLampTest {
	private ThreeWayLamp threeWayLamp;

	/**
	 * Set up the instance variable. Initiates to 0/OFF.
	 */
	@Before
	public void setUp() {
		threeWayLamp = new ThreeWayLamp();
	}

	@Test
	public void testLamp () {
		Assert.assertEquals(LampSetting.OFF, threeWayLamp.currentSetting());

		threeWayLamp.switchSetting();
		threeWayLamp.switchSetting();

		assertEquals(LampSetting.MEDIUM, threeWayLamp.currentSetting());

		threeWayLamp.switchSetting();
		threeWayLamp.switchSetting();

		assertEquals(LampSetting.OFF, threeWayLamp.currentSetting());
	}
}
