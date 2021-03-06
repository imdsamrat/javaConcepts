package multithreading;

public class MultiThreadingDemo {
	public static void main(String[] args) {
		int n = 8; // Number of threads
		for (int i = 0; i < n; i++) {
			MultiThread object = new MultiThread(i);
			object.start();
		}
	}
}
