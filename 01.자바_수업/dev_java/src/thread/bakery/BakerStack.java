package thread.bakery;

import java.util.Vector;

public class BakerStack {
	private Vector<String> breads = new Vector<>();
	//빵을 가져가는 메소드
	public synchronized String pop() {
		String bread = null;
		while(breads.size()==0) {
			try {
				System.out.println("빵이 곧 만들집니다. 잠시만 기다려주세요.");
				this.wait();//스레드를 잠시 멈춤.
			} catch (InterruptedException e) {
				System.out.println("여기....새치기");
			}
		}
		bread = breads.remove(breads.size()-1);
		return bread;
	}
	//빵을 진열하는 메소드
	public synchronized void push(String bread) {
		System.out.println("오래 기다리셨습니다. 빵을 가져가세요.");
		this.notify();//잠자는 스레드를 다시 깨운다.
		breads.add(bread);
	}
}
