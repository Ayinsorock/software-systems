package ss.week4.test;

import org.junit.Before;
import org.junit.Test;
import ss.week3.math.Integrable;
import ss.week4.Polynomial;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PolynomialTest {
	private static final double DELTA = 1e-15;
	private Polynomial polynomial;

	@Before
	public void setUp(){
		this.polynomial = new Polynomial(Arrays.asList(1.0, 2.0, 3.0));
	}

	@Test
	public void testApply() {
		assertEquals(6.0, this.polynomial.apply(1.0), PolynomialTest.DELTA);
		assertEquals(34.0, this.polynomial.apply(3.0), PolynomialTest.DELTA);
	}

	@Test
	public void testDerivative() {
		Integrable derivative = this.polynomial.derivative();

		assertEquals(8.0, derivative.apply(1), PolynomialTest.DELTA);
		assertEquals(26.0, derivative.apply(4), PolynomialTest.DELTA);
	}

	@Test
	public void testIntegral() {
		Integrable integral = this.polynomial.integral();

		assertEquals(3 + Polynomial.C, integral.apply(1), PolynomialTest.DELTA);
		assertEquals(39 + Polynomial.C, integral.apply(3), PolynomialTest.DELTA);
	}
}
