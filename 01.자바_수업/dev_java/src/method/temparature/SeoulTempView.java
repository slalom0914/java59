package method.temparature;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SeoulTempView implements ActionListener {
	//선언부
	Connection 			con 	= null;//전역변수 선언하기 - 클래스() 전역에서 사용가능함.
	//오라클 서버에 쿼리문을 전달하고 너가 좀 처리해 줄래
	PreparedStatement 	pstmt 	= null;
	//오라클에는 일꾼이 살고 있는데 이름은 옵티마이저라고 함.
	//데이터를 찾을 때는 커서를 움직이면서 조회결과가 존재하는지 확인하고 그 로우에 있는 값들을
	//RAM메모리 영역에 올린다.  커서를 조작하면서 해당 로우에 있는 값을 꺼낼 수 있다.
	ResultSet 		rs  		= null;
	JTextField 		jtf_date 	= new JTextField("날짜를 입력하세요.");
	JButton 		jbtn_search = new JButton("조회");
	//오라클에서 조회한 결과를 담을 클래스 선언 및 생성하기
	//테이블의  헤더 설정하기
	String 			cols[]      = {"날짜","최저온도","최고온도"};
	String 		    data[][] 	= new String[4][3];
	//생성자에는 파라미터를 가질 수 있다.
	//첫번째 파라미터는 데이터영역을 표시하는 주소번지
	//두번째 파라미터는 테이블 헤더영역에 해당하는 주소번지
	//파라미터의 갯수에 따라서 서로 다른 생성자를 선언하는 것도 가능하다는 것인가?
	DefaultTableModel dtm_zip	= new DefaultTableModel(data,cols);
	//테이블 양식 그려줌.
	JTable		    jt_zip 		= new JTable(dtm_zip);
	JScrollPane     jsp_zip		= new JScrollPane(jt_zip);
	//JTableHeader
	JTableHeader    jth_zip		= new JTableHeader();
	JFrame			jf_zip		= new JFrame();//운영체제위에 창을 띄운다.
	JPanel 			jp_north	= new JPanel();//속지를 만들어 준다.	
	JComboBox		jcb_year	= null;
	JComboBox		jcb_month	= null;
	String 			years[]     = null;//오라클서버 경유해서 반환받는 값으로 초기화
	SeoulTempDAO    stDao	    = new SeoulTempDAO();
	//생성자
	public SeoulTempView() {
		//오라클 서버 경유하기
		years=stDao.getYearList();
		//오라클 서버 경유하고 나서 받은 리턴값으로 콤보박스 인스턴스화 하기
		jcb_year = new JComboBox(years);
		//생성자에서 메소드 호출 할 수 있다.
		initDisplay();
	}
	
	//화면 처리부
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jth_zip = jt_zip.getTableHeader();
		jth_zip.setBackground(new Color(22,22,100));
		jth_zip.setForeground(Color.white);
		jth_zip.setFont(new Font("맑은고딕",Font.BOLD,16));
		jt_zip.setGridColor(Color.BLUE);//그리드 색상
		//그리드의 높이 변경하기
		jt_zip.setRowHeight(20);
		//컬럼의 너비 조정하기
		jt_zip.getColumnModel().getColumn(0).setPreferredWidth(350);
		//선택한 로우의 배경색이나 글자색 변경하기
		jt_zip.setSelectionBackground(new Color(186,186,241));
		jt_zip.setSelectionForeground(new Color(22,22,100));
		//이벤트가 일어난 소스와 이벤트를 처리하는 클래스(actionPerformed메소드)를 연결해준다.
		//jp_north속지에는 중앙에 jtf_dong을 붙이고 동쪽에는 jbtn_search를 붙인다.
		//이렇게 동,서,남,북,중앙 에 버튼을 배치하고 싶으면 BorderLayout사용함.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.setBackground(Color.red);
		jp_north.add(jcb_year);
		jp_north.add(jtf_date);
		jp_north.add(jbtn_search);
		jbtn_search.addActionListener(this);
		jtf_date.addActionListener(this);
		jf_zip.setTitle("서울기후통계 검색");
		//JFrame판넬 위에 북쪽에 jp_north속지를 붙이자.
		//속지 안에 버튼과 텍스트필드가 붙어 있으니까 같이 따라온다.
		jf_zip.add("North",jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setSize(600, 500);
		jf_zip.setVisible(true);		
	}
	//전체조회 혹은 조건검색 하기 구현
	//insert here                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	
	
	//메인메소드
	public static void main(String[] args) {
		new SeoulTempView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
