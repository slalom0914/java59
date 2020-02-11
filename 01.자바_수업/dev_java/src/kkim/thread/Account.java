package kkim.thread;

public class Account {
	private int balance = 1000;
	public int getBalance() {
		return balance;
	}
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
			//if문을 통과하자마자 다른 스레드에게 제어권이 넘기도록 하였지만
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			balance -= money;
		}
	}////////////end of withdraw
}
