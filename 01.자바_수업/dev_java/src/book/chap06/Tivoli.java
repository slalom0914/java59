package book.chap06;
/*
 * 10번 12번 14번의 주소번지 모두 다른 값일 것이다.
 * 10번 12번은 같지만 14번은 다를 것이다.
 * 10번 12번 14번 모두 같은 주소값을 가질 것이다.
 */
public class Tivoli {
	public int speed  = 0;
	public static void main(String[] args) {
		Tivoli myCar = new Tivoli();
		myCar.speed = 30;
		System.out.println("myCar 주.번 :"+myCar);
		System.out.println("나는 현재 "+myCar.speed+"로 가는 중이야.");
		//자바에서는 같은 이름의 변수를 중복선언불가
		myCar = new Tivoli();
		myCar.speed = 50;
		System.out.println("나는 현재 "+myCar.speed+"속도를 내고 있어.");
		System.out.println("myCar2 주.번 :"+myCar);
		Tivoli herCar = new Tivoli();
		herCar.speed = 100;
		System.out.println("나는 현재 "+herCar.speed+"속도로 달리고 있어.");
		System.out.println("herCar 주.번 :"+herCar);
	}
}
