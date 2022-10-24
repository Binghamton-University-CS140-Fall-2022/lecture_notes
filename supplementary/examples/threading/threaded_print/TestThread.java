package thread;
class TestThread {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("format: testThread \"number of threads\" \"number of iterations through the loop\" \"<run as threads>\"");
            System.exit(0);
        }       
        // get the number of threads
        int numberOfThreads = Integer.parseInt(args[0]);
        // get the number of iterations through the loop for each thread
        int numberOfIteractions = Integer.parseInt(args[1]);
        // define whether we will run as threads or non-threads
        boolean runAsThreads = true;
        if(args.length > 2) {
            if(args[2].toLowerCase().startsWith("f") || args[2].toLowerCase().startsWith("n")) {
                runAsThreads = false;
            }
        }
        // allocate an array for the PrintToScreenThread  
        PrintToScreenThread[] printToScreenThreads = new PrintToScreenThread[numberOfThreads];
        // allocate an array for the runnables
        Thread[] printToScreenRunnables = new Thread[numberOfThreads];
        // allocate boolean arrays to keep track of which are still running
        boolean[] isDead = new boolean[numberOfThreads];
        boolean[] isDeadRunnable = new boolean[numberOfThreads];
        // create the threads
        for(int i = 0; i < numberOfThreads; i++) {
            printToScreenThreads[i] = new PrintToScreenThread(""+i, i*100, numberOfIteractions);
        }
        // create the threads for the runnables
        for(int i = 0; i < numberOfThreads; i++) {
            printToScreenRunnables[i] = new Thread(new PrintToScreenRunnable(""+i, i*100, numberOfIteractions));
        }
        long t0 = System.currentTimeMillis();
        // start the threads
        for(int i = 0; i < numberOfThreads; i++) {
            if(runAsThreads) {
                printToScreenThreads[i].start();
            } else {
                printToScreenThreads[i].run();
            }
        }
        // start the runnable threads
        for(int i = 0; i < numberOfThreads; i++) {
            if(runAsThreads) {
                printToScreenRunnables[i].start();
            } else {
                printToScreenRunnables[i].run();
            }
        }
        // check which are still alive, and output when they transition from running to not running
        boolean done = false;
        while(!done) {
            done = true;
            for(int i = 0; i < numberOfThreads; i++) {
                // check if the thread has transitioned from running to no longer running
                if(!printToScreenThreads[i].isAlive()) {
                    if(!isDead[i]) {
                        System.out.println("\t" + "PrintToScreenThread" + i + " is no longer alive (" + (System.currentTimeMillis()-t0) + ")");
                        isDead[i] = true;
                    }
                }
                done = done && isDead[i];
            }
            // check if the thread has transitioned from running to no longer running
            for(int i = 0; i < numberOfThreads; i++) {
                if(!printToScreenRunnables[i].isAlive()) {
                    if(!isDeadRunnable[i]) {
                        System.out.println("\t" + "printToScreenRunnables" + i + " is no longer alive (" + (System.currentTimeMillis()-t0) + ")");
                        isDeadRunnable[i] = true;
                    }
                }
                done = done && isDeadRunnable[i];
            }
        }
    }
}