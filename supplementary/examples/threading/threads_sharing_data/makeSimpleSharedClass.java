package thread;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
class MakeSimpleSharedClass {
    public static void main(String[] args) {
        int numberOfThreads = 10;

        // define the delay time spent in the shared class while making updates
        // this wants to simulate the processing time required to make the updates
        int delayInMilliSeconds = 0;
        int delayInNanoSeconds = 1;

        // the semaphore
        Semaphore semaphore = new Semaphore(1, true);

        // the lock
        ReentrantLock lock = new ReentrantLock(true);

        // threads that don't properly access shared memory
        SimpleSharedClass sharedClass = new SimpleSharedClass(delayInMilliSeconds, delayInNanoSeconds);

        // threads that access shared memory properly with synchronized methods
        SimpleSharedClassSync sharedClassSync = new SimpleSharedClassSync(delayInMilliSeconds, delayInNanoSeconds);

        // threads that access shared memory properly with a semaphore
        SimpleSharedClassSemaphore sharedClassSemaphore = new SimpleSharedClassSemaphore(delayInMilliSeconds, delayInNanoSeconds, semaphore);

        // threads that access shared memory properly with a lock
        SimpleSharedClassLock sharedClassLock = new SimpleSharedClassLock(delayInMilliSeconds, delayInNanoSeconds, lock);

        // define SimpleSharedClassProcessor arrays to hold the numberOfThreads copies of each
        SimpleSharedClassProcessor[] simpleSharedClassProcessor = new SimpleSharedClassProcessor[numberOfThreads];
        SimpleSharedClassProcessor[] simpleSharedClassProcessorSync = new SimpleSharedClassProcessor[numberOfThreads];
        SimpleSharedClassProcessor[] simpleSharedClassProcessorSemaphore = new SimpleSharedClassProcessor[numberOfThreads];
        SimpleSharedClassProcessor[] simpleSharedClassProcessorLock = new SimpleSharedClassProcessor[numberOfThreads];

        // initialize the threads
        for(int i = 0; i < simpleSharedClassProcessor.length; i++) {
            simpleSharedClassProcessor[i] = new SimpleSharedClassProcessor(sharedClass);
            simpleSharedClassProcessorSync[i] = new SimpleSharedClassProcessor(sharedClassSync);
            simpleSharedClassProcessorSemaphore[i] = new SimpleSharedClassProcessor(sharedClassSemaphore);
            simpleSharedClassProcessorLock[i] = new SimpleSharedClassProcessor(sharedClassLock);
        }

        long t0 = System.currentTimeMillis();

        // start all of the threads
        for(int i = 0; i < simpleSharedClassProcessor.length; i++) {
            simpleSharedClassProcessor[i].start();
            simpleSharedClassProcessorSync[i].start();
            simpleSharedClassProcessorSemaphore[i].start();
            simpleSharedClassProcessorLock[i].start();
        }

        System.out.println("the correct output should be value = " + numberOfThreads*250);

        // when all elements of each thread type finishes, output the toString() for each thread type
        boolean done = false;
        boolean doneSync = false;
        boolean doneSemaphore = false;
        boolean doneLock = false;
        while((!done) || (!doneSync) || (!doneSemaphore) || (!doneLock)) {
            int aliveCount = 0;
            int aliveSyncCount = 0;
            int aliveSemaphoreCount = 0;
            int aliveLockCount = 0;

            for(int i = 0; i < simpleSharedClassProcessor.length; i++) {
                if(simpleSharedClassProcessor[i].isAlive()) {
                    aliveCount = aliveCount+1;
                }
                if(simpleSharedClassProcessorSync[i].isAlive()) {
                    aliveSyncCount = aliveSyncCount+1;
                }
                if(simpleSharedClassProcessorSemaphore[i].isAlive()) {
                    aliveSemaphoreCount = aliveSemaphoreCount+1;
                }
                if(simpleSharedClassProcessorLock[i].isAlive()) {
                    aliveLockCount = aliveLockCount+1;
                }
            }
            if((!done) && (aliveCount == 0)) {
                done = true;
                System.out.println("sharedClass.toString() " + sharedClass.toString() + " (" + (System.currentTimeMillis()-t0) + "ms)");
            }
            if((!doneSync) && (aliveSyncCount == 0)) {
                doneSync = true;
                System.out.println("sharedClassSync.toString() " + sharedClassSync.toString() + " (" + (System.currentTimeMillis()-t0) + "ms)");
            }
            if((!doneSemaphore) && (aliveSemaphoreCount == 0)) {
                doneSemaphore = true;
                System.out.println("sharedClassSemaphore.toString() " + sharedClassSemaphore.toString() + " (" + (System.currentTimeMillis()-t0) + "ms)");
            }
            if((!doneLock) && (aliveLockCount == 0)) {
                doneLock = true;
                System.out.println("sharedClassLock.toString() " + sharedClassLock.toString() + " (" + (System.currentTimeMillis()-t0) + "ms)");
            }
        }

        // this is redundant, but we could replace the above "complex" code to wait until all the threads complete
        for(int i = 0; i < simpleSharedClassProcessor.length; i++) {
            try {
                simpleSharedClassProcessor[i].join();
                simpleSharedClassProcessorSync[i].join();
                simpleSharedClassProcessorSemaphore[i].join();
                simpleSharedClassProcessorLock[i].join();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}