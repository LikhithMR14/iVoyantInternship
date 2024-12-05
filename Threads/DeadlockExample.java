//class Pen {
//    public synchronized void writeWithPenAndPaper(Paper paper) {
//        System.out.println(Thread.currentThread().getName() + "is using Pen " + this + " and trying to use Paper " );
//        paper.finishWriting();
//    }
//
//    public synchronized void finishWriting() {
//        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
//    }
//}
//
//class Paper {
//    public synchronized void writeWithPenAndPaper(Pen pen) {
//        System.out.println(Thread.currentThread().getName() + "is using Paper " + this + " and trying to use Pen " );
//        pen.finishWriting();
//    }
//
//    public synchronized void finishWriting() {
//        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
//    }
//}
//
//class Task1 implements Runnable {
//    private Pen pen;
//    private Paper paper;
//
//    public Task1(Pen pen, Paper paper) {
//        this.pen = pen;
//        this.paper = paper;
//    }
//
//    public void run() {
//        paper.writeWithPenAndPaper(pen);
//    }
//}
//
//class Task2 implements Runnable {
//    private Pen pen;
//    private Paper paper;
//
//    public Task2(Pen pen, Paper paper) {
//        this.pen = pen;
//        this.paper = paper;
//    }
//
//    public void run() {
//        pen.writeWithPenAndPaper(paper);
//    }
//}
//
//public class DeadlockExample {
//        public static void main(String[] args) {
//            Pen pen1 = new Pen();
//            Pen pen2 = new Pen();
//            Paper paper1 = new Paper();
//            Paper paper2 = new Paper();
//
//            Task1 task1 = new Task1(pen1, paper2);
//            Task2 task2 = new Task2(pen2, paper1);
//
//            Thread thread1 = new Thread(task1,"MyThread1");
//            Thread thread2 = new Thread(task2,"MyThread2");
//
//            thread1.start();
//            thread2.start();
//        }
//}

class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to use paper " + paper);
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to use pen " + pen);
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper); // thread1 locks pen and tries to lock paper
    }
}

class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        //If u enclose the below one line code with a synchronised block giving with the object of pen as an argument then the deadlock will not be caused
            paper.writeWithPaperAndPen(pen); // thread2 locks paper and tries to lock pen
    }
}


public class DeadlockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread(new Task1(pen, paper), "Thread-1");
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread-2");

        thread1.start();
        thread2.start();
    }
}