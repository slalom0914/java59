package kkim.thread;

public class ThreadEx21 {

	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		new Thread(r).start();
		new Thread(r).start();
	}

}
