package book.chap08;

public class Parent {
	public String book = null;
	public Parent() {
		System.out.println("Parent 디폴트 생성자 호출 성공");
	}
	public void bookRead() {
		System.out.println("1달에 2권씩 책을 읽습니다.");
	}
	//메소드 오버로딩이라고 한다.
	//반드시 파라미터의 갯수나 파라미터의 타입이 달라야 한다.
	public void bookRead(String book1, String book2) {
		System.out.println("이달에는 "+book1+"과 "+book2+"를 읽습니다.");
	}
}
