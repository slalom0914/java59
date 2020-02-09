package friday0207;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseBallGameEvent implements ActionListener {
	BaseBallGameView bbView = null;
	BaseBallGameLogic bbLogic = new BaseBallGameLogic();
	//게임을 진행하는 동안에는 계속 그 숫자를 기억하고 있다가 1씩 증가되야 하니까...
	//전역변수로 해야 함.
	int cnt = 0;//회차를 출력할 변수 선언
	public BaseBallGameEvent(BaseBallGameView bbView) {
		this.bbView = bbView;
	}
	public void exitGame() {
		System.exit(0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//insert here
		//BaseBallGameView bbView = new BaseBallGameView();
		if(obj == bbView.jbtn_exit) {
			System.out.println("나가기 버튼 호출 성공");
			exitGame();
		}
		//다음겜을 누른거니?
		else if(obj == bbView.jbtn_next) {
			System.out.println("다음겜 버튼 호출 성공");
			cnt = 0;
			bbLogic.ranCom();
			//BaseBallGameLogic안에 com배열이 선언되어 있음.
			//인스턴스화를 한 상태이므로 접근이 가능함.
			for(int coms:bbLogic.com) {
				System.out.print(coms+"");
			}
			System.out.println();
		}
		//세자리 숫자를 입력했어?
		else if(obj == bbView.jtf_input) {
			bbView.jta_display.append(++cnt+"회 : "+bbView.jtf_input.getText()+"\n");
			bbView.jtf_input.setText("");
		}
	}

}











