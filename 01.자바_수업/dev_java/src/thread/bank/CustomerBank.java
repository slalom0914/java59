package thread.bank;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomerBank extends JFrame {
	Socket socket = null;
	ObjectInputStream ois = null;//읽기-듣기
	ObjectOutputStream oos = null;//쓰기-말하기	
	String mem_id = null;
	JPanel jp_south = new JPanel();
	JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER);
	JTextArea jta_clog = new JTextArea(8,30);
	JScrollPane jsp_clog = new JScrollPane(jta_clog
			                             ,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			                             ,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
	public CustomerBank() {
		mem_id = JOptionPane.showInputDialog("아이디를 입력하세요.");
		if(mem_id == null) {
			return;//생성자 탈출-아래 메소드 2개는 호출이 안되요.
		}
		initDisplay();
		connect_process();
	}
	private void initDisplay() {
		jp_south.setLayout(new BorderLayout());//배치를 위한 설정-중앙,남쪽
		jp_south.add("Center",jsp_clog);
		jp_south.add("South",jlb_time);
		this.setTitle(mem_id +"님 계좌입니다.");
		//this.add("Center",jsp_clog);
		this.add("South",jp_south);
		this.setSize(500, 400);
		this.setVisible(true);				
	}
	//서버에 접속하기 구현
	public void connect_process() {
		try {
			socket = new Socket("192.168.0.244",3000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			//클라이언트가 말한 내용을 듣기
			ois = new ObjectInputStream(socket.getInputStream());
			oos.writeObject(100+"#"+mem_id);
		} catch (Exception ie) {
			System.out.println("은행서버에 접속할 수 없습니다.");
		}		
	}
	//타임서버에 접속하기 구현
	public void time_process() {
		
	}
	public static void main(String[] args) {
		CustomerBank cb = new CustomerBank();
	}

}
