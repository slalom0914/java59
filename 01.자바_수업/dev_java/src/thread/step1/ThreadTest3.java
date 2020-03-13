package thread.step1;

import javax.swing.JOptionPane;
class ThreadTest3_1 extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);//1초동안 지연
			} catch (InterruptedException e) {
				System.out.println("인터셉트를 당하면?????");
			}
		}		
	}
}
/*
 *  사용자로 부터 입력받는 부분과 화면에 출력하는 부분을 두 개의 스레드로 나누어 처리했으므로
 *  사용자가 입력을 마치지 않았어도 화면에 숫자가 출력되는 것을 관찰하였다.
 */
public class ThreadTest3 {

	public static void main(String[] args) {
		ThreadTest3_1 tt3 = new ThreadTest3_1();
		tt3.start();
		String msg = JOptionPane.showInputDialog
				("0부터 9사이의 숫자를 입력하세요.");
		System.out.println("당신이 입력한 숫자는 ==>"+msg);
	}

}
