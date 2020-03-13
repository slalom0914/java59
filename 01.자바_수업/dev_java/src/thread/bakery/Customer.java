package thread.bakery;

public class Customer extends Thread {
	private BakerStack bs = null;
	public Customer(BakerStack bs) {
		this.bs = bs;
	}
	public void run() {
		String bread = null;
		for(int i=0;i<5;i++) {
			//빵주세요.
			bread = bs.pop();
			//고객이 사간 빵이름 출력
			System.out.println("손님이 가져가는 빵 "+bread);
			try {
				sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}			
		}
	}
}
