package thread.talk;

import java.util.List;

import javax.swing.JFrame;

public class TalkServer extends JFrame implements Runnable {
	TalkServerThread tst = null;
	List<TalkServerThread> globalList = null;
	//서버소켓과 클라이언트측 소켓을 연결하기
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		
	}

}
