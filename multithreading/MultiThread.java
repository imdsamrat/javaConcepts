package multithreading;

public class MultiThread extends Thread {
	int time;
	
	public MultiThread(int time){
		this.time = time;
	}
	public void run() {
		try {
			sleep(time*1000);
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}
