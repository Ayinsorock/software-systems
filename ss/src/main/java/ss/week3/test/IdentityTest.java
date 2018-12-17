package ss.week3.test;

import org.junit.Before;
import org.junit.Test;

import ss.week3.math.Constant;
import ss.week3.math.Identity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IdentityTest {
    private static final double DELTA = 1e-15;
    private Identity identity;

    @Before
    public void setUp() {
    	identity = new Identity();
    }

    @Test
    public void testApply() {
        assertEquals(0.0, identity.apply(0.0), DELTA);
        assertEquals(1.0, identity.apply(1.0), DELTA);
        assertEquals(2.0, identity.apply(2.0), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(identity.derivative() instanceof Constant);
        assertEquals(1.0, identity.derivative().apply(0), DELTA);
    }
}
