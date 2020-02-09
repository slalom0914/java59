package book.chap05;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TV {
	JFrame jf = new JFrame();
	JButton jbtn = new JButton("전원");
	//전역변수는 그 클래스가 활동 중에는 계속 유지(기억) 됩니다.
	//TV의 속성을 정의해 보세요.
	String 	color 	= null;//색상을 담았어요
	boolean power 	= false;//전원상태를 나타냅니다(on/off)
	int 	channel = 2;//채널을 바꿔봐요
	
	//TV의 기능을 구현해 봅시다.
	/******************************************************
	 * power의 경우 값에 상관없이 항상 반대의 값으로 변경해주면 되므로 
	 * 굳이 if문을 사용하지 않아도 될 것 같아요.
	 *****************************************************/
	void power() {
		power = !power;
	}
	/* 메소드의 파라미터자리는 사용자가 선택한 값, 입력한 값 등을 받아오는 자리 입니다.
	 * u_power=true가 저장됨
	 * 28라인에서 그 변수에 not이 있으므로 반대인 false변환 후 대입된다.
	 * false->true
	 */
	void power(boolean u_power) {//호출할 때 결정된 값이 넘어오는 변수입니다.
		power = !u_power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}
