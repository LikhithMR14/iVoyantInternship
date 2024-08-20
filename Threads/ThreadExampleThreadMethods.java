class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i=1;
        while(true) {
            System.out.println(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}



public class ThreadExampleThreadMethods {
    public static void main(String[] args) {
        MyThread1 t=new MyThread1("FirstThread");
        System.out.println("ID: " + t.getId());
        System.out.println("Name: " + t.getName());
        t.start();
        System.out.println("State: " + t.getState());
        System.out.println("Priority: " + t.getPriority());
        System.out.println("Alive: " + t.isAlive());

    }
}
