public class VolatileKeywordExample {
    private volatile boolean flag = true;

    public void toggleFlag() {
        flag = !flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public static void main(String[] args) {
        VolatileKeywordExample example = new VolatileKeywordExample();

        // Thread 1: Toggle the flag
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                example.toggleFlag();
                System.out.println("Thread 1 toggled flag to: " + example.isFlag());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: Read the flag
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2 read flag: " + example.isFlag());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
