package study.bank;

public class BankTest {

	public static void main(String[] args) {
		Bank bank = new Bank("자바나라","123-456-789",10000);
		bank.deposit(15000);
		bank.take(30000);
		bank.print();
	}

}
