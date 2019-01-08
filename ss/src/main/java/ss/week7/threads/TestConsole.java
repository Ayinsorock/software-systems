package ss.week7.threads;

public class TestConsole extends Thread {
    public static void main (String[] args) {
        TestConsole threadA = new TestConsole("Thread A");
        TestConsole threadB = new TestConsole("Thread B");

        threadA.start();
        threadB.start();
    }

    public TestConsole (String threadName) {
        super(threadName);
    }

    public void run () {
        sum();
    }

    private void sum () {
        String threadName = getName();

        int firstNum = Console.readInt(threadName +  ": get number 1?");
        int secondNum = Console.readInt(threadName + ": get number 2?");

        System.out.println(threadName + ": " + firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
    }
}
