package thread.bank;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import design.book.TimeServerThread;
//인터페이스를 추가하면 반드시 구현체 클래스가 되기 위해서 추상메소드를 재정의해야 함.-규칙
//run메소드를 반드시 오버라이딩 해야 한다.
//이 메소드 안에서는 무엇을 하지? - 기다려[Thread.sleep(1000)], 듣기[ois.readObject()]와 말하기[oos.writeObject("메시지")]
public class ServerBank extends JFrame implements Runnable {
    /////////////////전역변수 선언하기 시작//////////////////
	Socket socket = null;//복사본이 아니라 원본을 사용해야 하니까 반드시 null로 초기화
	int port= 3000;
	//서버소켓은 사용자가 접속해 오기를 기다립니다. 언제까지 기다려야 할지 알 수 없죠..
	ServerSocket server = null;	
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log
			                             ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                             ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	/////////////////전역변수 선언하기   끝//////////////////	
	//메인메소드는 entry point이다.
	//메인 스레드라고도 한다. - 경합 벌어진다.
	//화면처리와 서버 개통하기
	//스레드 클래스의 run메소드는 어떻게 호출하지?
	public static void main(String[] args) {
		ServerBank sb = new ServerBank();
		sb.initDisplay();
		//sb.start();왜냐하면 Thread상속 받지 않았으니까- 나는 스레드가 아님.
		//어떻게 해결하지? - 일단 Thread를 인스턴스화 하고 생성자에 구현체클래스를 넣어줌
		Thread th = new Thread(sb);
		th.start();//run메소드 호출하기
	}

	@Override
	public void run() {
		JOptionPane.showMessageDialog(this, "run호출 성공-스레드 가동 중");
		try {
			server = new ServerSocket(port);//가게 문 열고 기다리는 중....손님이 언제 올까(ip,port)
		} catch (Exception e) {
			e.printStackTrace();
		}//////////////end of try
		jta_log.append("ServerBank started successfully...\n");
		while(true) {//무한루프 - while탈출 불가
			try {
		//클라이언트측에서 접속해온 정보를 client소켓에게 넘김.		
				socket = server.accept();//대기
				jta_log.append("New Client connected...."+socket.toString()+"\n");
				//tst = new TimeServerThread(this);
				//tst.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}						
	}
	public void initDisplay() {
		this.setTitle("ServerBank 로그창");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);		
	}
}
