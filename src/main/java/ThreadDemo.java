import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo extends Thread {
    private static final int UPPER_BOUND = 100;
    private final String threadName;
    private final AtomicInteger counter;

    public ThreadDemo(String threadName, AtomicInteger counter) {
        this.threadName = threadName;
        this.counter = counter;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        while (true) {
            synchronized (counter) {
                if (counter.get() >= UPPER_BOUND) {
                    break;
                }
                System.out.println(threadName + ": " + counter.getAndIncrement());
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
