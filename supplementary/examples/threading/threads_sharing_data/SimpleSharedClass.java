package thread;
class SimpleSharedClass implements SimpleSharedClassFunctions {
    private int delayInMilliSeconds;
    private int delayInNanoSeconds;
    private int value;

    SimpleSharedClass(int delayInMilliSec, int delayInNanoSec) {
        value = 0;
        delayInMilliSeconds = delayInMilliSec;
        delayInNanoSeconds = delayInNanoSec;
    }

    public void decreaseValue(int v) {
        int x = value;
        pause(delayInMilliSeconds, delayInNanoSeconds);
        value = x - v;
    }

    public void increaseValue(int v) {
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