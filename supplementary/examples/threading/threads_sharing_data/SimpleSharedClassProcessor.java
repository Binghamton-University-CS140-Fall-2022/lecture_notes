package thread;
class SimpleSharedClassProcessor extends Thread {
    private final SimpleSharedClassFunctions simpleSharedClass;
    SimpleSharedClassProcessor(SimpleSharedClassFunctions simpleSharedClass) {
        this.simpleSharedClass = simpleSharedClass;
    }
    public void run() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                simpleSharedClass.increaseValue(1);
                simpleSharedClass.increaseValue(2);
            }
            simpleSharedClass.decreaseValue(5);
        }
    }
}