class MyData2 {
    synchronized void display(String str) {
//        synchronized (this) {
//            for (int i=0;i<str.length();i++) {
//                System.out.print(str.charAt(i));
//            }
//        }
        for (int i=0;i<str.length();i++) {
                System.out.print(str.charAt(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread5 extends Thread {
    MyData2 d;
    MyThread5(MyData2 func) {
        this.d=func;
    }

    @Override
    public void run() {
        d.display("Helloooooooooooooooooooiuouoiuiouoiuoiuwwwwwwwwwwwwwwwwwwwwwwwww");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}

class MyThread6 extends Thread {
    MyData2 dot;
    MyThread6(MyData2 func) {
        this.dot=func;
    }

    @Override
    public void run() {
        dot.display("Worlddddddddddddddddddddddddddddddddddddd");

    }
}

public class SyncronisedThreadExample {
    public static void main(String[] args) {
        MyData2 d=new MyData2();
        MyThread5 t5=new MyThread5(d);
        MyThread6 t6=new MyThread6(d);
        t5.start();
        t6.start();
    }
}
