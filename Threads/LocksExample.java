import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance=100;
    private final Lock lock=new ReentrantLock();

    public void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount );
        if(lock.tryLock(4000, TimeUnit.MILLISECONDS)) {
            if(balance>=amount) {
                System.out.println(Thread.currentThread().getName() + " proceeding with Withdrawal" );
                try {
                    Thread.sleep(3000);
                    balance-=amount;
                    System.out.println(Thread.currentThread().getName() + " completed Withdrawal. Remaining amount: " + balance);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " Insufficient Balance!");
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + " could not acquire the lock, Please try again later");
        }
    }

}



public class LocksExample {
    public static void main(String[] args) {
        BankAccount account=new BankAccount();
        Runnable rn=new Runnable() {
            @Override
            public void run() {
                try {
                    account.withdraw(50);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread t1=new Thread(rn,"First");
        Thread t2=new Thread(rn,"Second");
        t1.start();
        t2.start();
    }
}
