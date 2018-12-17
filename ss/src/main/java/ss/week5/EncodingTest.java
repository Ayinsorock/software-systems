package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";

        System.out.println(Hex.encodeHexString(input.getBytes()));

        printBase64("a");
        printBase64("b");
        printBase64("aa");
        printBase64("aaa");
        printBase64("aaaa");
        printBase64("aaaaa");
        printBase64("aaaaaa");
        printBase64("...");
        printBase64("aaaaaaaa");
    }

    private static void printBase64 (String input) {
        System.out.println("Original:\t"+  input + ". \nBase64:\t\t" + Base64.encodeBase64String(input.getBytes()));
    }
}
