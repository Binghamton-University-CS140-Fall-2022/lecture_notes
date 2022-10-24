package thread;
class PrintToScreenThread extends Thread {
    private String name;
    private int delay;
    private int printCount;

    PrintToScreenThread(String nameIn, int delayIn, int pCount) {
        name = "PrintToScreenThd" + nameIn;
        delay = delayIn;
        printCount = pCount;
    }

    public void run() {
        long t0 = System.currentTimeMillis();
        for(int i = 0; i < printCount; i++) {
            System.out.println(name + " " + i + " " + (System.currentTimeMillis()-t0));
            try {
                sleep(delay);
            } catch(InterruptedException e) {
                System.out.println(e.toString());
                System.exit(0);
            }
        }
    }
}