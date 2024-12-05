import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {
        final int permits = 3;
        Semaphore semaphore = new Semaphore(permits);

        // Start multiple threads
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(semaphore)).start();
        }
    }

    static class Worker implements Runnable {
        private final Semaphore semaphore;

        Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // Acquire a permit
                System.out.println(Thread.currentThread().getName() + " acquired a permit.");

                // Simulate some work
                Thread.sleep(1000);

                System.out.println(Thread.currentThread().getName() + " released a permit.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Release the permit
            }
        }
    }
}
