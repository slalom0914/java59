package book.chap08;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ChatRoom extends JFrame {
	//JTable헤더에 들어갈 정보들의 이름을 1차배열로 선언하기
	String cols[] = {"톡방명","총인원수","현재참여자명단"};
	//JTable에 들어갈 데이터 영역을 생성하기
	//데이터는 존재하지 않으므로 0을 주었고 컬럼의 수는 톡방명,총인원수, 현재 참여자 명단
	//이렇게 3이므로 3을 주었음
	String data[][] = new String[0][3];
	//실제로 데이터를 담을 수 있는 자바에서 제공되는 클래스임
	//화면에 붙일때 헤더정보들은 2차배열에 포함시키지 않음. 
	DefaultTableModel dtm_room = new DefaultTableModel(data,cols);
	//JTable은 양식을 제공할 뿐 데이터는 DefaultTableModel에 초기화되어야 함.
	JTable jtb_room = new JTable(dtm_room);
	//JScrollPane은 일종의 속지로 스크롤되는 화살표를 지원해줌
	JScrollPane jsp_room = new JScrollPane(jtb_room);
	public ChatRoom() {
		//따라서 최종적으로 화면에 붙일 때 JTabe이 아닌 JScrollPane을 붙음.
		this.add("Center",jsp_room);
		//창닫기시 자원반납처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new ChatRoom();
	}

}
