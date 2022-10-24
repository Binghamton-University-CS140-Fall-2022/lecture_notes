package thread;
class SimpleSharedClassSync implements SimpleSharedClassFunctions {
    private int delayInMilliSeconds;
    private int delayInNanoSeconds;
    private int value;
    SimpleSharedClassSync(int delayInMilliSec, int delayInNanoSec) {
        value = 0;
        delayInMilliSeconds = delayInMilliSec;
        delayInNanoSeconds = delayInNanoSec;
    }
    public synchronized void decreaseValue(int v) {
        int x = value;
        pause(delayInMilliSeconds, delayInNanoSeconds);
        value = x - v;
    }
    public synchronized void increaseValue(int v) {
        int x = value;
        pause(delayInMilliSeconds, delayInNanoSeconds);
        value = x + v;
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