package test.d20200219;

public class Bank {
	String name = null;//예금주
	//String name2 = "";
	String account = null;//계좌번호
	int cash = 0;//잔액
	public Bank() {
		
	}
	public Bank(String name, String account, int cash) {
		this.name = name;
		this.account = account;
		this.cash = cash;
	}
	public void deposit(int money) {//입금하기
		cash = cash+money;
	}
	public void take(int money) {//얼마를 가져갈 거니? - 파라미터
		if(cash >= money) {
			cash = cash - money;
		}
		else if(cash < money) {
			System.out.println("잔액이 부족해~~~");
			return;
		}
	}
	public String toString() {
		String accountINFO 
		= "예금주는 "+name+"이고, 계좌번호는 "+account
		 +" 잔액은 "+cash+"원 입니다.";
		return accountINFO;
	}
	public void print() {
		System.out.printf
		("예금주는 %s 이고, 계좌번호는 %s 잔액은 %d 입니다.",name,account,cash);
	}
}





