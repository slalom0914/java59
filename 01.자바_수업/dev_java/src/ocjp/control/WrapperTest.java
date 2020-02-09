package ocjp.control;
//객체지향적 언어
//절차지향적 언어 - C언어 - 순서대로 실행됨
/*
 * 변수의 종류
 * 1.원시형타입(primative data type) - 부르면 값이 반환
 * 참조형 타입이 아니라서 변수나 메소드를 누릴 수 없다.
 * 2.참조형타입(reference data type) - Sonata, String, Tivoli
 * 부르면 주소번지가 반환됨.
 */
public class WrapperTest {
	int i;
	static void methodA() {
		//int i = new int();
		Integer i = new Integer(10);
		//오토박싱 개념추가
		//변수 i는 클래스급이고 변수 j는 원시형 타입이라서 서로 급이 다름
		int j = i;
		//오토박싱이 나오기 전에는 반드시  래퍼클래스 타입을 원시형 타입으로 바꾸어 주는
		//메소드를 태워야 했음.
		//String s = i.intValue();
		j = i.intValue();
		Boolean b = new Boolean(false);
		boolean b1 = b;
		String str = "false";
		Boolean b2 = Boolean.valueOf(str);
		if(b2) {
			
		}
	}
	public static void main(String[] args) {
		//원시형 타입에는 8가지가 있다.
		//int, boolean, double
		//Integer, Boolean, Double Wrapper클래스라고 함.
		//원시형 타입인 int에도 메소드를 가지게 하고 싶다.
		methodA();
	}

}
