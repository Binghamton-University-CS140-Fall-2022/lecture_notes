package thread;
import java.util.concurrent.locks.ReentrantLock;
class SimpleSharedClassLock implements SimpleSharedClassFunctions {
    private int delayInMilliSeconds;
    private int delayInNanoSeconds;
    private int value;
    private final ReentrantLock lock;
    SimpleSharedClassLock(int delayInMilliSec, int delayInNanoSec,
            ReentrantLock lockIn) {
        value = 0;
        delayInMilliSeconds = delayInMilliSec;
        delayInNanoSeconds = delayInNanoSec;
        lock = lockIn;
    }
    public void decreaseValue(int v) {
        lock.lock();
        try {
            int x = value;
            pause(delayInMilliSeconds, delayInNanoSeconds);
            value = x - v;
        } finally {
            lock.unlock();
        }
    }
    public void increaseValue(int v) {
        lock.lock();
        try {
            int x = value;
            pause(delayInMilliSeconds, delayInNanoSeconds);
            value = x + v;
        } finally {
            lock.unlock();
        }
    }
    public String toString() {
        return "value = " + value;
    }
    private void pause(int delayInMilliSeconds, int delayInNanoSeconds) {
        try {
            Thread.sleep(delayInMilliSeconds, delayInNanoSeconds);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}