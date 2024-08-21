class Counter {
    private int counter=0;

    public synchronized void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}

class MyThread7 extends Thread {
    Counter ct;

    MyThread7(Counter ct) {
        this.ct=ct;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
            ct.increment();
        }
    }
}

public class SyncronisedThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        Counter ct=new Counter();
        MyThread7 t1=new MyThread7(ct);
        MyThread7 t2=new MyThread7(ct);

//        write the below code without synchronized keyword for increment() to achieve 2000 i.e expected output
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ct.getCounter());

    }
}
