public class ThreadExample{
	public static void main(String[] args){
		TExample t = new TExample();
		t.start();
	}
	
	// Now you cannot extend any other class as java does not support multiple inheritance
	static class TExample extends Thread{
		@Override
		public void run(){
			System.out.println("Run method called");
		}		
	}
}
