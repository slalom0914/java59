package book.chap08;

public class CarTest2 {

	public static void main(String[] args) {
		Car myCar = null;
		Tivoli herCar = new Tivoli();
		myCar = herCar;
		//결론:두 변수가 같은 주소번지를 갖는다.
		System.out.println(myCar+", "+herCar);
		myCar.speed = 10;
		herCar.speed = 100;
		System.out.println(myCar.speed);
		System.out.println(herCar.speed);
		if(myCar instanceof Car) {
			System.out.println("myCar는 Car클래스 타입입니다.");
		}else {
			System.out.println("myCar는 Car클래스 타입이 아니다.");
		}
		if(herCar instanceof Car) {
			System.out.println("herCar는 Car클래스 타입입니다.");
		}
		if(herCar instanceof Tivoli) {
			System.out.println("herCar는 Tivoli클래스 타입입니다.");
		}else {
			System.out.println("herCar는 Car클래스 타입이 아니다.");
		}
	}
}



