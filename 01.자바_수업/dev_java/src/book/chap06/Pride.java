package book.chap06;

public class Pride {
	int speed = 10;
	//디폴트 생성자 구현하기 - 파라미터가 없는 생성자임
	//JVM이 대신 만들어 줄 수 있는 생성자 - 
	Pride(){
		
	}
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
