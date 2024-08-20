class MyThread extends Thread {
    public void run() {
        int i=0;
        while(i<100) {
            System.out.println(i + " Hello");
            i++;
        }
    }
}

class ThreadExampleUsingThreadClass {
    public static void main(String[] args) {
        MyThread t=new MyThread();
        t.start();
        int i=0;
        while(i<100) {
            System.out.println(i + " World");
            i++;
        }
    }
}