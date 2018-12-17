package ss.week1;

public class Division {
    /**
     * @param args command-line arguments; currently unused
     */
    public static void main (String [] args) {
        int n = 7;
        int m = 6;

        System.out.println("n / m");
        System.out.println(n / m);

        System.out.println("(double) n / (double) m");
        System.out.println((double) n / (double) m);

        System.out.println("(double) n / m");
        System.out.println((double) n / m);

        System.out.println("n / (double) m");
        System.out.println(n / (double) m);

        System.out.println("(double)(n / m)");
        System.out.println((double)(n / m));
    }
}
