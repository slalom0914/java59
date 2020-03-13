package thread.step1;

import javax.swing.JOptionPane;

public class ThreadTest2 {

	public static void main(String[] args) {
		String msg = JOptionPane.showInputDialog
				("0부터 9사이의 숫자를 입력하세요.");
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);//1초동안 지연
			} catch (InterruptedException e) {
				System.out.println("인터셉트를 당하면?????");
			}
		}
		System.out.println("당신이 입력한 숫자는 ==>"+msg);
	}

}
