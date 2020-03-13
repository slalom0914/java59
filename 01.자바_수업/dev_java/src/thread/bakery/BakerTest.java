package thread.bakery;

public class BakerTest {

	public static void main(String[] args) {
		BakerStack bs = new BakerStack();
		Baker b1 = new Baker(bs);
		Thread bth1 = new Thread(b1);
		bth1.start();
		Customer c1 = new Customer(bs);
		Thread cth1 = new Thread(c1);
		cth1.start();
		Customer c2 = new Customer(bs);
		Thread cth2 = new Thread(c2);
		cth2.start();
		Customer c3 = new Customer(bs);
		Thread cth3 = new Thread(c3);
		cth3.start();
	}

}
