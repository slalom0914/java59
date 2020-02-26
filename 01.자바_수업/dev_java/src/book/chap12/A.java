package book.chap12;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class A {
//클래스 A에서 메소드 4개를 호출해 보자.
	public static void main(String args[]) {
		B b = new B();
		List<String> list = new ArrayList<>();//싱글스레드안전-동기화구현이 안되어 있다.-속도빠름
		List<String> list2 = new Vector<>();//멀티스레드안전-동기화 구현함-속도느림
		ArrayList<String> nameList = new ArrayList<>();
		Vector<String> mailList = new Vector<>();
		b.methodA(list);
		b.methodA(list2);
		b.methodA(nameList);
		b.methodA(mailList);
	}
}







