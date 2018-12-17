package ss.week1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import ss.week1.ThreeWayLamp;

/**
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
        assertEquals(ThreeWayLamp.OFF, threeWayLamp.currentSetting());

        threeWayLamp.switchSetting();
        threeWayLamp.switchSetting();

        assertEquals(ThreeWayLamp.MEDIUM, threeWayLamp.currentSetting());

        threeWayLamp.switchSetting();
        threeWayLamp.switchSetting();

        assertEquals(ThreeWayLamp.OFF, threeWayLamp.currentSetting());
    }
}
