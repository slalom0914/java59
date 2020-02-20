package test.d20200219;

public class BankApp {

	public static void main(String[] args) {
		Bank bank = new Bank("자바맨","123-456-789",10000);
		System.out.println(bank.toString());
		bank.deposit(15000);
		bank.take(30000);

	}

}
