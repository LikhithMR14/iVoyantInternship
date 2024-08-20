public class ThreadExampleUsingRunnableInterfaceInSameClass implements Runnable {

    @Override
    public void run() {
        int i=0;
        while (i<100) {
            System.out.println(i + " Hello");
            i++;
        }
    }

    public static void main(String[] args) {
        ThreadExampleUsingRunnableInterfaceInSameClass m=new ThreadExampleUsingRunnableInterfaceInSameClass();
        Thread t=new Thread(m);
        t.start();
        int i=0;
        while(i<100) {
            System.out.println(i + " World!");
            i++;
        }
    }
}
