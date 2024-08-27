public class ThreadLocalExample {

    // Create a ThreadLocal variable
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {

        // Create a task that increments the ThreadLocal variable
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                // Get the current value of the ThreadLocal variable
                int value = threadLocal.get();
                // Increment the value
                value++;
                // Set the new value back to the ThreadLocal variable
                threadLocal.set(value);

                // Print the thread name and the current value
                System.out.println(Thread.currentThread().getName() + " value: " + threadLocal.get());
            }
        };

        // Create and start two threads
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
