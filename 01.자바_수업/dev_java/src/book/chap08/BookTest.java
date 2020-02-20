package book.chap08;

import java.util.ArrayList;

class Book1{
	public String b_title = null;
	public String b_author = null;
}
public class BookTest {
	public static void main(String[] args) {
		//ArrayList는 읽기 쓰기(저장)를 위해 존재함.
		//다이아몬드 연산자를 사용하여 제네릭을 표현함.
		//제네릭 안에는 클래스 설계 가능함.
		ArrayList<Book1> library = new ArrayList<>();
		Book1 b1 = new Book1();
		b1.b_title = "태백산맥";
		b1.b_author = "조정래";
		library.add(b1);
		String title = library.get(0).b_title;
		System.out.println("책제목 : "+title);
	}
}



