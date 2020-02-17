package book.chap08;

public class ChildSimuation2 {
//상속관계를 이용하면 재사용성이 높아지므로 코딩량이 줄어든다.
//코딩량이 줄어야 오타 발생도 줄어들것 아닌가
//업무의 내용이 변경된다 하더라도 가능한 코드를 적게 수정하다록 클래스 설계를 하여야 한다.	
	public static void main(String[] args) {
		int i = 5;
		double d = i;
		Parent p = new Parent();
		Child c = new Child();
		//오른쪽 타입이 왼쪽 타입보다 상위클래스가 올 수 없다.
		//항상 하위클래스만 가능하다.
		p = c;//p = new Child();
		//insert here 만일 p로 bookRead메소드를 호출하였다면 어떤 클래스의
		//메소드가 호출되었을까?
		//12번 라인에서 원래는 Parent객체를 가리켰으나 Child객체로 변경되였다.
		p.bookRead();
		//c = p;//c = new Parent();
		
	}
}











