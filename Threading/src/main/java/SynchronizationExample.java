public class SynchronizationExample {
	public static void main(String[] args){
		MyObject obj = new MyObject("sample");
		Thread t1 = new Thread(new ExampleRunnable("t1", obj));
		Thread t2 = new Thread(new ExampleRunnable("t2", obj));
		t1.start();
		t2.start();
	}
}

class MyObject {
	String n;
	
	public MyObject(String name){
		this.n = name;
	}

	public synchronized void foo(String name){
		System.out.println("foo method started " +  name + " " + this.n);
		try{
			Thread.sleep(6000);
		}catch(InterruptedException ex) {
			System.out.println("Thread interuppted");
		}
		System.out.println("foo method ended " +  name + " " + this.n);
	}
	
	public void boo(String name) {
		System.out.println("boo method started " +  name + " " + this.n);
		synchronized(this){
			this.n = "asdasdad";			
		}
		try {
			Thread.sleep(3000);
		} catch(InterruptedException ex) {
			System.out.println("Thread interuppted");
		}
		System.out.println("boo method ended " +  name + " " + this.n);
	}
	
	public synchronized static void foo1(String name) { 
		System.out.println("static synchronized void foo1 method started " +  name);
		try{
			Thread.sleep(3000);
		}catch(InterruptedException ex) {
			System.out.println("Thread interuppted");
		}
		System.out.println("static synchronized void foo1 method ended " +  name);
	}

	public synchronized static void boo1(String name) { 
		System.out.println("static synchronized void boo1 method started " +  name);
		try{
			Thread.sleep(3000);
		}catch(InterruptedException ex) {
			System.out.println("Thread interuppted");
		}
		System.out.println("static synchronized void boo1 method ended " +  name);
	}
}

class ExampleRunnable implements Runnable{
	private String name;
	private MyObject obj;

	public ExampleRunnable(String name, MyObject obj){
		this.name = name;
		this.obj = obj;
	}
	
	@Override
	public void run(){
		if (this.name.equals("t1")) this.obj.foo(this.name);
		else if (this.name.equals("t2")) this.obj.boo(this.name);
		// this.obj.foo(this.name);
	}
}