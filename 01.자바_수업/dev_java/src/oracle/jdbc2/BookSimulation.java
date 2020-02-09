package oracle.jdbc2;
class Book{
	String title = null;
	int price = 0;
	public static Book getBook() {
		return new Book();
	}
}
public class BookSimulation {

	public static void main(String[] args) {
		Book myBook = new Book();
		//메소드를 호출해서 객체를 주입 받을 수도 있다. - 이런 느낌
		Book gnomBook = Book.getBook();
		System.out.println(myBook+" , "+gnomBook);
	}

}
