public class ThreadExampleUsingThreadClassInSameClass extends Thread {
    public void run() {
        int i=1;
        while(i<100) {
            System.out.println(i + " Hello");
            i++;
        }
    }

    public static void main(String[] args) {
        ThreadExampleUsingThreadClassInSameClass t=new ThreadExampleUsingThreadClassInSameClass();
        t.start();
        int i=0;
        while(i<100) {
            System.out.println(i + " World!");
            i++;
        }
    }
}
