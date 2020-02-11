package kkim.thread;

public class RunnableEx21 implements Runnable {
	Account acc = new Account();
	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			//100, 200, 300중의 한 값을 임의로 선택해서 출금(withdraw)
			int money = (int)(Math.random()*3 + 1)*100;
			acc.withdraw(money);
			System.out.println("balance:"+acc.getBalance());
		}
	}////////////end of run
}
