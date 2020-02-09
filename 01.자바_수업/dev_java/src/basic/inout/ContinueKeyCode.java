package basic.inout;

public class ContinueKeyCode {

	public static void main(String[] args) throws Exception {
		int keyCode;
		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode : "+keyCode);
			if(keyCode == 113) {
				break;//if문 탈출이 아닌 while문 탈출
			}
		}
		System.out.println("종료");
	}
}
