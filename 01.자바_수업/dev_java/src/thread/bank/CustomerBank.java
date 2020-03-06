package thread.bank;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class CustomerBank extends JFrame {
	Socket socket = null;
	ObjectInputStream ois = null;//읽기-듣기
	ObjectOutputStream oos = null;//쓰기-말하기	
	String mem_id = null;
	JPanel jp_center = new JPanel();
	String cols[] = {"대화명"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm_nickName 
					= new DefaultTableModel(data,cols);
	JTable jtb_nickName = new JTable(dtm_nickName);
	JScrollPane jsp_nickName = new JScrollPane(jtb_nickName
			,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);			
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
		jp_center.setLayout(new GridLayout(1,2));//배치를 위한 설정-중앙,남쪽
		jp_center.add(jsp_nickName);
		jp_south.add("Center",jsp_clog);
		jp_south.add("South",jlb_time);
		this.setTitle(mem_id +"님 계좌입니다.");
		this.add("Center",jp_center);
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
			CustomerBankThread cbt = new CustomerBankThread(this);
			cbt.start();
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
