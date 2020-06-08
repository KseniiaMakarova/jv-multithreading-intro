public class ThreadDemo extends Thread {
    private final String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
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
