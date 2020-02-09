package book.chap06;

public class Pride {
	int speed = 10;
	public static void main(String[] args) {
		Pride myCar = new Pride();
		System.out.println("myCar : "+myCar);
		System.out.println(myCar.speed);
		myCar = null;
		myCar = new Pride();
		myCar.speed=100;
		System.out.println("myCar : "+myCar);
		System.out.println(myCar.speed);
	}

}
