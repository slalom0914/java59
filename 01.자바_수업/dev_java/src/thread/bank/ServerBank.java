package thread.bank;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

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
	JTextArea jta_log = new JTextArea(12,30);
	JScrollPane jsp_log = new JScrollPane(jta_log
			                             ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                             ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
	String cols[] = {"접속시간","접속자","메시지","상태"};
	String data[][] = new String[0][4];
	DefaultTableModel dtm_history 
					= new DefaultTableModel(data,cols);
	JTable jtb_history = new JTable(dtm_history);
	JScrollPane jsp_history = new JScrollPane(jtb_history
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
	//클라이언트에서 접속해온 사용자에 대한 스레드를 담기 위한 List선언
	//일단 선언만 해두었다가 서버소켓이 개설되기 직전에 인스턴스화 함.
	//List는 인터페이스이므로 단독으로 인스턴스화 불가하니까 구현체 클래스 중에서
	//여러 사람을 손실없이 관리할 수 있는 Vector객체를 생성할 것.
	//클라이언트가 접속을 했을 때 스레드를 가동시킴.
	//ServerBankThread가 서버측에서 생성한 클래스이지만 그 안에 담긴 정보는 클라이언트에
	//대한 정보를 담고 있다.
	//클라이언트가 접속 성공하면 일반소켓에게 서버소켓이 수집한 정보를 넘김.
	//이 정보를 넘겨받으면 그 안에 클라이언트 정보가 담김.
	//스레드가 생성되었을 때 그 때 Vector안에 add처리할 것.-그래야 그사람 정보를 유지가능
	//담는 작업은 스레드가 생성되었을 때 거의 동시에 일어나는 사건이므로 생성자 안에서 처리함.
	List<ServerBankThread> globalList = null;//멀티스레드
	ServerBankThread sbt = null;
	CustomerDao cDao = new CustomerDao();
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
		globalList = new Vector<ServerBankThread>();
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
				sbt = new ServerBankThread(this);//this-ServerBank자신-원본-생성자 호출
				sbt.start();//스레드에 구현된 run메소드 호출
			} catch (Exception e) {
				e.printStackTrace();
			}
		}						
	}
	public void initDisplay() {
		//윈도우 창에서 X버튼 클릭했을 때 이벤트 처리
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {//사용 자원 반납하기
					server.close();
					socket.close();
					System.exit(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		this.setTitle("ServerBank 로그창");
		this.add("West",jsp_log);
		this.add("Center",jsp_history);
		this.setSize(900, 400);
		this.setVisible(true);		
	}
}











