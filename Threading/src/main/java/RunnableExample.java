// Runnable is an interface. So it will let you implement multiple other interfaces along with it. You can also extend other class.
public class RunnableExample implements Runnable{
	@Override
	public void run(){
		System.out.println("Run method called");
	}
	
	public static void main(String[] args){
		RunnableExample r = new RunnableExample();
		Thread t = new Thread(r);
		t.start();
	}
}