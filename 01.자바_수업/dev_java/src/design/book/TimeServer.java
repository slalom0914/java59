package design.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*
 * 자바에서는 단일 상속만 가능함.
 * 다중 상속이 필요할 땐 인터페이스로 대신한다.
 * 여기서 처럼 JFrame을 이미 상속받은 경우 Thread를 또 상속받을 수 없다.
 * 이런 경우를 지원하기 위해서 Runnable이라는 인터페이시를 지원함.
 */
public class TimeServer extends JFrame implements Runnable {
	Socket socket = null;//복사본이 아니라 원본을 사용해야 하니까 반드시 null로 초기화
	int port= 3000;
	//서버소켓은 사용자가 접속해 오기를 기다립니다. 언제까지 기다려야 할지 알 수 없죠..
	ServerSocket server = null;	
	JTextArea jta_log = new JTextArea();
	JScrollPane jsp_log = new JScrollPane(jta_log
			                             ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                             ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	List<TimeServerThread> globalList = null;
	TimeServerThread tst = null;
	public TimeServer() {
	}
	public String setTimer() {
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);//1~24
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		return (hour < 10 ? "0"+hour:""+hour)+":"+
			   (min < 10 ? "0"+min:""+min)+":"+
			   (sec < 10 ? "0"+sec:""+sec);
	}
	public void run() {//지연처리가능, 들은 정보를 내보낼 수 있다., 1초에 한번씩 시간정보를 내보낸다.
		globalList = new Vector<>();
		try {
			server = new ServerSocket(port);//가게 문 열고 기다리는 중....손님이 언제 올까(ip,port)
		} catch (Exception e) {
			e.printStackTrace();
		}//////////////end of try
		jta_log.append("TimeServer started successfully...\n");
		while(true) {//무한루프 - while탈출 불가
			try {
		//클라이언트측에서 접속해온 정보를 client소켓에게 넘김.		
				socket = server.accept();//대기
				jta_log.append("New Client connected...."+socket.toString()+"\n");
				tst = new TimeServerThread(this);
				tst.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}				
	}
	/*
	 * main메소드안에서 만들어진 정보를 run메소드에서 사용하려면 생성자를 통해서
	 * 초기화를 해주어야 한다.
	 * 복사본을 사용하는 것이 아니라 메인에서 접속한 클라이언트의 소켓 원본을 사용해야 하니까.
	 */
	public static void main(String[] args) {
		TimeServer ts = new TimeServer();
		ts.initDisplay();//화면을 그리고 난 뒤 스레드 대기를 타도록 해야함.
		Thread th = new Thread(ts);
		th.start();//스레드의 run메소드를 호출하는 메소드
	}/////////////////end of main
	public void initDisplay() {
		this.setTitle("TimeServer 로그");
		this.add("Center",jsp_log);
		this.setSize(500, 400);
		this.setVisible(true);
	}
}













