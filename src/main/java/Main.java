import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        Thread firstThread = new ThreadDemo("Thread", counter);
        Thread secondThread = new Thread(new RunnableDemo("Runnable", counter));
        firstThread.start();
        secondThread.start();
        firstThread.join();
        secondThread.join();
        System.out.println("Returning to main thread");
        System.out.println("Value: " + counter.get());
    }
}
