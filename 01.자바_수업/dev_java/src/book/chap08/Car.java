package book.chap08;
//자동차 - 완전 추상적이다.
public class Car {
	int speed;
	Car(){
		speed = 0;
	}
	public void stop() {
		System.out.println("stop호출 성공");
		if(speed>0) {
			speed = speed-1;
		}
	}
}
