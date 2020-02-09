package friday0207;
//클래스 A,B,C에는 main메소드가 없다.
class A{
	B b = new B();//11번호출됨
	String name = null;
	A(){
		System.out.println("디폴트 A생성자.");
	}
	A(String name){
		System.out.println("파라미터가 name인 A생성자.");
		this.name =name;
	}
	
	/*
	 * A(ABCTest abc){ System.out.println("파라미터가 ABCTest타입인 A생성자."); }
	 */
}
class B{
	A a = new A();
	B(){
		System.out.println("디폴트 B생성자.");
	}
}
class C{
	A a = new A();
	B b = new B();
}
public class ABCTest {
//22-23-3-6
//클래스 안에 디폴트 생성자를 생략할 수도 있고 명시적으로 선언할 수도 있다.	
	ABCTest(){
		A a1 = new A(this);//this - ABCTest
	}
	public static void main(String[] args) {
		new ABCTest();
		//A a1 = new A("이순신");//디폴트 A생성자 호출 그리고 heap메모리에 로딩됨.
	}

}
