package ss.week7.account;

import static java.lang.Thread.State.TERMINATED;

public class AutoSync {
    private static final double AMOUNT = 1.00;
    private static final int FREQUENCY = 100;
    private static final Account ACCOUNT = new Account();

    public static void main (String[] args) {
        MyThread addThread = new MyThread(AMOUNT, FREQUENCY, ACCOUNT);
        MyThread retractThread = new MyThread(-1 * AMOUNT, FREQUENCY, ACCOUNT);

        addThread.start();
        retractThread.start();

        while (addThread.getState() != TERMINATED && retractThread.getState() != TERMINATED) {
            //
        }

        System.out.println("Balance: " + ACCOUNT.getBalance());
    }
}
