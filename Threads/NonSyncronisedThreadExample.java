class MyData {
    void display(String str) {
        for (int i=0;i<str.length();i++) {
            System.out.print(str.charAt(i));
        }
    }
}

class MyThread3 extends Thread {
    MyData2 d;
    MyThread3(MyData2 func) {
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

class MyThread4 extends Thread {
    MyData2 dot;
    MyThread4(MyData2 func) {
        this.dot=func;
    }

    @Override
    public void run() {
        dot.display("Helloooooooooooooooooooiuouoiuiouoiuoiuwwwwwwwwwwwwwwwwwwwwwwwww");

    }
}

public class NonSyncronisedThreadExample {
    public static void main(String[] args) {
        MyData2 d=new MyData2();
        MyThread3 t3=new MyThread3(d);
        MyThread4 t4=new MyThread4(d);
        t3.start();
        t4.start();
    }
}
