package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedIntCell implements IntCell {
    private int value;
    private boolean unread = false;
    private final Lock intCellLock = new ReentrantLock();
    private final Condition notFull = intCellLock.newCondition();
    private final Condition notEmpty = intCellLock.newCondition();

    @Override
    public void setValue(int value) {
        intCellLock.lock();
        try {
            while (unread)
                notEmpty.await();

            this.value = value;
            unread = true;
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            intCellLock.unlock();
        }
    }

    @Override
    public int getValue() {
        intCellLock.lock();
        try {
            while (!unread)
                notFull.await();

            notEmpty.signal();
            unread = false;
            return this.value;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            intCellLock.unlock();
        }
    }
}
