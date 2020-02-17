package book.chap08;

public class ChildSimuation {

	public static void main(String[] args) {
		//Parent p 	= new Parent();
	//선언부의 타입이 아닌 생성부의 타입으로 객체가 생성되는 것이다.
	    //Parent p1 	= new Child();
	    //문제:도대체 Child c는 Parent 클래스의 메소드와 오버라이딩 관계에 있다는 것을
	    //어떻게 알게 되는 걸까요?
		//자녀클래스를 인스턴스화 하더라도 먼저 부모클래스의 디폴트 생성자를 먼저 호출합니다.
		//이 과정을 통해서 부모의 메소드의 정보를 알게 됩니다.
		Child c 	= new Child();
		//p로 누릴 수 있는 것들을 코드로 작성해 보시오.
		//p.book ="말의 힘";
		//p.bookRead();
		//System.out.println(p.book);
		//p.bookRead(p.book, "자바프로그래밍 입문");
		//p1로 누릴 수 있는 것들을 작성해 보시오.
		
		//c로 누릴 수 있는 변수나 메소드들을 호출해 보시오.
		//Child에 선언되지 않은 변수이지만 상속관계에 있으므로 누릴 수 있다.
		c.book = "오라클프로그래밍";
		/*
		 * 동일한 메소드가 부모와 자식 모두에게 있을 경우 선언한 타입에서 제공하는 
		 * 메소드가 호출 된다.
		 * 이 때 부모가 가진 bookRead메소드는 호출 할수가 없다.
		 * 왜냐하면 자녀타입으로 선언하였으므로 자식클래스에 선언된 메소드가 호출된다.
		 */
		c.bookRead();
		//문제 : 만일 p1으로 동일한 메소드를 호출 한다면 어떤 메소드가 호출될까요?
		//1)부모클래스의 메소드가 호출된다.
		//2)자식클래스의 메소드가 호출된다.
		//p1.bookRead();
		//p1.bookRead(c.book, p.book);
	}
}











