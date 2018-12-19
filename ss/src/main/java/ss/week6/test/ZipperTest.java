package ss.week6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ss.week6.ArgumentLengthsDifferException;
import ss.week6.TooFewArgumentsException;
import ss.week6.WrongArgumentException;
import ss.week6.Zipper;

/**
 * Testprogram for Zipper.
 * Lab Exercise SoftwareSystems
 * @author Jip Spel
 * @version $Revision: 1.0 $
 */
public class ZipperTest {
    /**
     * Test for zipping with too few arguments
     */
    @Test(expected=TooFewArgumentsException.class)
    public void testFirstArgumentNull() throws WrongArgumentException {
        Zipper.zip2(null, "Hello World!");
    }

    /**
     * Test for zipping with too few arguments
     */
    @Test(expected=TooFewArgumentsException.class)
    public void testSecondArgumentNull() throws WrongArgumentException {
        Zipper.zip2("Hello World!", null);
    }

    /**
     * Test for zipping with arguments of different length
     */
    @Test(expected=ArgumentLengthsDifferException.class)
    public void testDifferentArgumentLengths() throws WrongArgumentException {
        Zipper.zip2("Hello World!", "Hello World");
    }

    @Test
    public void testCorrectInput() throws WrongArgumentException {
        assertEquals("HelloWorld", Zipper.zip2("Hlool", "elWrd"));
    }

}
