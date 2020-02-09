package book.chap02;

public class SonataSimulation {

	public static void main(String[] args) {
		Sonata meCar = new Sonata();
		meCar.carColor = "흰색";//초기화를 다시 하였다.
		meCar.carColor = "자주";
		// 발자취 null-흰색-자주
		//변수의 값은 재정의 가능함.
	}

}
