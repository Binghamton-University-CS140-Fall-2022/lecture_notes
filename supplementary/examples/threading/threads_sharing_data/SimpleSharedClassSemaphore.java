package thread;
import java.util.concurrent.Semaphore;
class SimpleSharedClassSemaphore implements SimpleSharedClassFunctions {
    private int delayInMilliSeconds;
    private int delayInNanoSeconds;
    private int value;
    private final Semaphore semaphore;
    SimpleSharedClassSemaphore(int delayInMilliSec, int delayInNanoSec, Semaphore semaphoreIn) {
        value = 0;
        delayInMilliSeconds = delayInMilliSec;
        delayInNanoSeconds = delayInNanoSec;
        semaphore = semaphoreIn;
    }
    public void decreaseValue(int v) {
        try {
            semaphore.acquire();
        } catch(Exception e) {
            e.printStackTrace();
        }
        int x = value;
        pause(delayInMilliSeconds, delayInNanoSeconds);
        value = x - v;
        try {
            semaphore.release();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void increaseValue(int v) {
        try {
            semaphore.acquire();
        } catch(Exception e) {
            e.printStackTrace();
        }
        int x = value;
        pause(delayInMilliSeconds, delayInNanoSeconds);
        value = x + v;
        try {
            semaphore.release();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public String toString() {
        return "value = " + value;
    }
    private void pause(int delayInMilliSeconds, int delayInNanoSeconds) {
        try {
            Thread.sleep(delayInMilliSeconds, delayInNanoSeconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}