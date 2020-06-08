public class RunnableDemo implements Runnable {
    private final Thread thread;
    private final String threadName;

    public RunnableDemo(String threadName) {
        thread = new Thread(this, threadName);
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        for (int i = 0; i < 100; i++) {
            System.out.println(threadName + ", " + i);
        }
        System.out.println(threadName + " exiting.");
    }
}
