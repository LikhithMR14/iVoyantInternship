class MyRunnable implements Runnable {
    public void run() {
        int i=0;
        while(i<100) {
            System.out.println(i + " Hello");
            i++;
        }
    }
}


public class ThreadExampleUsingRunnableInterface {
    public static void main(String[] args) {
        MyRunnable m=new MyRunnable();
        Thread t=new Thread(m);
        t.start();
        int i=0;
        while(i<100) {
            System.out.println(i + " World");
            i++;
        }
    }
}
