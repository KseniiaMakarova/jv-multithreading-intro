public class Main {
    public static void main(String[] args) {
        RunnableDemo thread1 = new RunnableDemo("Runnable");
        thread1.start();

        ThreadDemo thread2 = new ThreadDemo("Thread");
        thread2.start();
    }
}
