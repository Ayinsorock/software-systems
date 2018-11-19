package ss.week1;

import java.util.Scanner;

public class ReadInt {
    public static void main (String[] args) {
        System.out.print(
                "========================================\n" +
                "==========EPIC NUMBER RECEIVER==========\n" +
                "========================================\n"
        );

        int value = readIntWithPrompt("Give me a numbah!!: ");

        System.out.println("Thank you for da numbah: " + value);
    }

    private static int readIntWithPrompt (String prompt) {
        Scanner in = new Scanner(System.in);

        System.out.print(prompt); System.out.flush();
        while (!in.hasNextInt()) {
            in.nextLine();
            System.out.print("THAT WAS NOT A NUMBAH!! AGAIN!: "); System.out.flush();
        }
        int input = in.nextInt();
        in.nextLine();

        return input;
    }
}
