package thread;
class PrintToScreenRunnable implements Runnable {
    private String name;
    private int delay;
    private int printCount;

    PrintToScreenRunnable(String nameIn, int delayIn, int pCount) {
        this.name = "PrintToScreenRun" + nameIn;
        this.delay = delayIn;
        this.printCount = pCount;
    }

    public void run() {
        long t0 = System.currentTimeMillis();
        for(int i = 0; i < printCount; i++) {
            System.out.println(name + " " + i + " " + (System.currentTimeMillis()-t0));
            try {
                Thread.sleep(delay);
            } catch(InterruptedException e) {
                System.out.println(e.toString());
                System.exit(0);
            }
        }
    }
}