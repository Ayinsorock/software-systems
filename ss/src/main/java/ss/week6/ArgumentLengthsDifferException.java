package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
    private int len1;
    private int len2;

    public ArgumentLengthsDifferException(int len1, int len2) {
        this.len1 = len1;
        this.len2 = len2;
    }

    public ArgumentLengthsDifferException () {
        //
    }
}
