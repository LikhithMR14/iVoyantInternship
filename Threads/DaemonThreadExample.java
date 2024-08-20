class MyThread2 extends Thread {
    @Override
    public void run() {
        int i=0;
        while(true) {
            System.out.println(i);
            i++;
        }
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread2 t=new MyThread2();
        t.setDaemon(true);                  //The Program ends when the main method ends without waiting for the thread t to complete due to deamon thread
        t.start();
        Thread.currentThread().join();
    }

}
