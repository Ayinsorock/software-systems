package ss.week6;

import java.util.Scanner;

public class Hello {
    public static void main (String[] args) {
        System.out.println("Who you being?");
        Scanner inStream = new Scanner(System.in);

        while (inStream.hasNext()) {
            System.out.println("Hello " + inStream.next());
        }
    }
}
