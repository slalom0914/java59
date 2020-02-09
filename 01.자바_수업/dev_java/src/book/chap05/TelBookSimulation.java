package book.chap05;

public class TelBookSimulation extends Object{
	public static void main(String[] args) {
		TelBook tb = new TelBook();
		System.out.println(tb);
		//toString메소드는 내 안에 없는 메소드 이지만 모든 클래스의 부모클래스인
		//Object안에 정의된 메소드임
		System.out.println(tb.toString());
	}

}
