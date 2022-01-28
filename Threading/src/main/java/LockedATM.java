import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class LockedATM {
 private Lock lock;
 private int balance = 100;

 public LockedATM() {
	this.lock = new ReentrantLock();
 }

 public int withdraw(int value) {
	this.lock.lock();
    System.out.println("withdraw started");
	int temp = balance;
	try {
		Thread.sleep(100);
		temp = temp - value;
		Thread.sleep(100);
		balance = temp;
	} catch (InterruptedException e) { }
    System.out.println("withdraw ended");
	lock.unlock();
	return temp;
 }

 public int deposit(int value) {
	this.lock.lock();
    System.out.println("deposit started");
	int temp = balance;
	try {
		Thread.sleep(100);
		temp = temp + value;
		Thread.sleep(300);
		balance = temp;
	} catch (InterruptedException e) {}
    System.out.println("deposit ended");
	lock.unlock();
	return temp;
}

	public static void main(String[] args){
		LockedATM obj = new LockedATM();
		Thread t1 = new Thread(new ExampleRunnable1("t1", obj));
		Thread t2 = new Thread(new ExampleRunnable1("t2", obj));
		t2.start();
		t1.start();
	}
} 

class ExampleRunnable1 implements Runnable{
	private String name;
	private LockedATM obj;

	public ExampleRunnable1(String name, LockedATM obj){
		this.name = name;
		this.obj = obj;
	}
	
	@Override
	public void run(){
		if (this.name.equals("t1")) this.obj.withdraw(10);
		else if (this.name.equals("t2")) this.obj.deposit(50);
		// this.obj.foo(this.name);
	}
}