package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BookApp extends JFrame implements ActionListener {
	//선언부
	static BookApp ba = null;
	//파라미터가 없는 생성자는 디폴트로 지원해주지만 있는 경우는 예측불가이므로 지원불가함.
	BookDialog bd = new BookDialog();
	//jp_north속지는 JFrame의 북쪽에 배치
	JPanel jp_north = new JPanel();
	//아래 버튼은 jp_north속지에 차례대로 배치-배치는 왼쪽부터 
	JButton jbtn_all = new JButton("전체조회");
	JButton jbtn_sel = new JButton("상세조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	//화면 그리기
	public void initDisplay() {
		//아래코드가 JFrame의 자원을 회수함.
		//부모자원이 회수될 때 JDialog도 같이 회수됨.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtn_ins.addActionListener(this);
		jbtn_sel.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		jbtn_all.addActionListener(this);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		//insert here
		this.setTitle("도서관리시스템");
		jp_north.add(jbtn_all);
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		this.add("North",jp_north);
		this.setSize(700, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		//insert here
		ba = new BookApp();
		ba.initDisplay();
	}
//JButton에 대한 이벤트를 지원하는 인터페이스가 ActionListener임.
//클래스 뒤에 implements할것
//ActionListener에 정의된 추상메소드를 재정의할것.	
	@Override
	public void actionPerformed(ActionEvent e) {
		//이벤트가 감지된 클래스의 주소번지 받기
		Object obj = e.getSource();
		//입력버튼을 누른거니?
		if(jbtn_ins==obj) {
			System.out.println("입력호출 성공");
			//insert here
			bd.set("입력", true, true, null, ba);
			//initDisplay를 호출한 이유는 setTitle("입력")과 setVisible(true)
			//때문이었다. 그런데 그  둘을 set메소드로 이전하였다.
		}
		else if(jbtn_upd==obj) {//수정시에는 먼저 기본 정보를 조회하고 화면이동
			System.out.println("수정호출 성공");
			//insert here
			//select처리한 후 한 개 로우를 받아서 Map에 저장
			Map<String,Object> rMap = null;
			rMap = new HashMap<>();
			rMap.put("b_title", "자바의 정석");
			bd.set(jbtn_upd.getText(), true, true, rMap, ba);
		}
		else if(jbtn_sel==obj) {
			System.out.println("상세조회호출 성공");
			//insert here
			Map<String,Object> rMap = null;
			bd.set(jbtn_sel.getText(), true, false, rMap, null);
		}
		else if(jbtn_del==obj) {
			System.out.println("삭제호출 성공");
		}
		
	}

	public void refreshData() {
		System.out.println("refreshData 호출 성공");
	}

}
