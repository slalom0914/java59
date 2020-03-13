package thread.bakery;
/*
 * 제빵사 클래스
 * 빵을 만들어서 진열장에 진열을 합니다.
 */
public class Baker extends Thread {
	private BakerStack bs = null;
	public Baker(BakerStack bs) {
		this.bs = bs;
	}	
	public void run() {
		String bread=null;//제빵사가 만든 빵이 저장
		for(int i=0;i<5;i++) {
			bread =  getBread();
			bs.push(bread);
			System.out.println("제빵사가 만든 빵 "+bread);		
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println(ie.toString());
			}
		}
	}
	//빵을 제공해 주는 메소드 구현
	public String getBread() {
		String bread = null;
		switch((int)(Math.random()*3)) {
		case 0:
			bread = "생크림빵";
			break;
		case 1:
			bread = "도너츠";
			break;
		case 2:
			bread = "마늘빵";
			break;
		}
		return bread;
	}
}
