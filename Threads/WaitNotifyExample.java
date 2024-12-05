class SharedResource {
    private boolean available = false;

    public synchronized void produce() {
        while (available) {
            try {
                wait();  // Wait until the resource has been consumed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Produce the resource
        System.out.println(Thread.currentThread().getName() + " produced a resource");
        available = true;
        notify();  // Notify the consumer
    }

    public synchronized void consume() {
        while (!available) {
            try {
                wait();  // Wait until the resource is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // Consume the resource
        System.out.println(Thread.currentThread().getName() + " consumed a resource");
        available = false;
        notify();  // Notify the producer
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable producerTask = () -> {
            for (int i = 0; i < 5; i++) {
                resource.produce();
            }
        };

        Runnable consumerTask = () -> {
            for (int i = 0; i < 5; i++) {
                resource.consume();
            }
        };

        Thread producerThread = new Thread(producerTask, "Producer");
        Thread consumerThread = new Thread(consumerTask, "Consumer");

        producerThread.start();
        consumerThread.start();
    }
}
