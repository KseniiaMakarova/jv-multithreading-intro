public class RunnableDemo implements Runnable {
    private final String threadName;
    private final Counter counter;

    public RunnableDemo(String threadName, Counter counter) {
        this.threadName = threadName;
        this.counter = counter;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        while (true) {
            synchronized (counter) {
                if (counter.getValue() >= Counter.UPPER_BOUND) {
                    break;
                }
                System.out.println(threadName + ": " + counter.getValue());
                counter.increment();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted");
            }
        }
        System.out.println(threadName + " exiting");
    }
}
