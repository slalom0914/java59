package study.bank;

public class Bank {
	//예금주를 담을 변수 선언
	String name = null;
	//계좌번호를 담을 변수 선언
	String account = null;
	//잔액을 담을 변수 선언
	int cash = 0;
	public Bank(String name, String account, int cash) {
		this.name = name;
		this.account = account;
		this.cash = cash;
	}
	public void print() {
		System.out.println(this);
	}
	/* 모든 클래스의 상위 클래스가 Object인데 이 클래스에는 toString메소드가 정의 되어
	 * 있다.
	 * 이 메소드를 자식 클래스가 재정의해서 사용할 수 있는데 이를 오버라이딩이라고 한다.
	 * 리턴값이 String인데 이것을 format형식을 지정하여 출력할 수 있도록 지원하고 있다.
	 * 메소드이름은 format이다.
	 * %s는 문자열 형식을 지원하는 예약어 이다.
	 * %n은 개행처리를 지원한다.
	 * %s가 세번 나왔으므로 파라미터도 3개가 되어야 한다.
	 */
	@Override
	public String toString() {
		return String.format("예금주 : %s, 계좌번호 : %s, 잔액 : %s"
				            ,name
				            ,account
				            ,cash);
	}
	public void take(int money) {
		//잔액이 인출 금액보다 큰가요?
		//잔액이 부족하면 인출이 안되는거죠
		if(cash >= money) {
			cash = cash - money;
			System.out.println("출금액 : "+money);
			System.out.println("잔액 : "+cash);
		}
		//잔액이 부족해요 ㅠㅠ
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	/*******************************************************
	 * 입금 처리 해봐요
	 * @param money 인자값이 입금할 금액입니다.
	 *******************************************************/
	public void deposit(int money) {
		cash += money;
		System.out.println("입금액 : "+money);
		System.out.println("잔액 : "+cash);
	}
}
