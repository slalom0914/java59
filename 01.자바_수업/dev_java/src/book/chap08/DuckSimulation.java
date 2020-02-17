package book.chap08;

public class DuckSimulation {
/* 
 * 선언부의 타입과 생성부의 타입이 다를 수 있다.
 * 결론 :생성부 타입으로 객체가 로딩된다.(생성된다, heap영역에 올라간다)
 * 그런데 선언부 타입이 그 메소드를 선언하고 있지 않으면 자식 클래스안에 
 * 그 메소드가 선언되어 있다 하더라도 호출할 수 없다.
 * 완결편 : 무조건 부모 타입에 선언된 메소드만 호출할 수 있다.
 */
	public static void main(String[] args) {
		Duck myDuck 	= new WoodDuck();//권장
		Duck herDuck 	= new RubberDuck();//권장
		Duck yourDuck 	= new MallardDuck();//권장
		WoodDuck gnomDuck 	= new WoodDuck();
		myDuck.fly();
		herDuck.fly();
		yourDuck.fly();
		gnomDuck.fly();
		myDuck.swimming();
	}

}
