package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Just using the synchronized keyword will not prevent the methods from executing simultaneously as the lock provided
 * is instance specific. As we are constructing two different instances of TestSyncConsole they don't share this lock.
 * By creating a lock outside of the instance and providing this to TestSyncConsole the instances share this lock
 * and the sum() methods won't interfere.
 *
 * Note: Intrinsic locks (as provided by the synchronized keyword) are reentrant locks.
 */

public class TestSyncConsole extends Thread {
    private ReentrantLock lock;

    public static void main (String[] args) {
        ReentrantLock lock = new ReentrantLock();
        TestSyncConsole threadA = new TestSyncConsole("Thread A", lock);
        TestSyncConsole threadB = new TestSyncConsole("Thread B", lock);

        threadA.start();
        threadB.start();
    }

    public TestSyncConsole (String threadName) {
        super(threadName);
    }

    public TestSyncConsole (String threadName, ReentrantLock lock) {
        this(threadName);

        this.lock = lock;
    }

    public void run () {
        sum();
    }

    private void sum () {
        lock.lock();
        String threadName = getName();

        int firstNum = SyncConsole.readInt(threadName +  ": get number 1?");
        int secondNum = SyncConsole.readInt(threadName + ": get number 2?");

        System.out.println(threadName + ": " + firstNum + " + " + secondNum + " = " + (firstNum + secondNum) + "\n");
        lock.unlock();
    }
}
