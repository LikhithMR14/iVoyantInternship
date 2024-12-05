public class ThreadStates extends Thread {

    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStates ts=new ThreadStates();
        System.out.println(ts.getState());
        ts.start();
        System.out.println(ts.getState());
        Thread.sleep(100);
        System.out.println(ts.getState());
        ts.join();
        System.out.println(ts.getState());
    }
}
