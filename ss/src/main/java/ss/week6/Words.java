package ss.week6;

import java.util.Scanner;

public class Words {
    public static void main (String[] args) {
        Scanner inStream = new Scanner(System.in);
        Scanner lineScanner;
        String word;
        int i;

        while(true) {
            System.out.print("Line (or \"end\"): ");
            i = 0;
            lineScanner = new Scanner(inStream.nextLine());

            while (lineScanner.hasNext()) {
                word = lineScanner.next();

                if (i == 0 && word.equals("end")) {
                    System.out.println("End of programme.");
                    return;
                }

                System.out.println("Word " + i + ": " + word); i++;
            }
        }
    }
}
