package method.zipcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.JDBCTest;
import oracle.jdbc2.ZipCodeVO;
//implements 뒤에 오는 이름 모두 인터페이스
//인터페이스는 추상메소드만 가지고 있다. 메소드 뒤에 세미콜론으로 끝남.
// void(int) methodA();
//인터페이스는 단독으로 인스턴스화를 할 수 없다.
//ItemListener item = new ItemListener();불법
//ItemListener item = new ZipCodeSearchApp();합법
//인터페이스는 반드시 구현체 클래스가 있어야 한다.
//구현체 클래스가 되기 위한 필요조건은 받드시 추상메소드를 구현해주어야 한다. @Override
public class ZipCodeSearchApp implements ItemListener, ActionListener, FocusListener {
/* 모든 클래스이 메인메소드가 있다면 이메소드가 시작점이다.
 * 이것보다 먼저 초기화 되는 코드들이 있다. 이것이 전변이다.	
 */
	String zdos[] = null;
	//사용자가 콤보박스에서 선택한 정보를 담을 변수 선언
	//선택은 이벤트 쪽에서 처리되므로 전역변수로 해야 그 값을 유지할 수 있고
	//또 조회메소드에서 그 값을 사용할 수 있을 것이다.
	String zdo = null;
	JComboBox jcb_zdo = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//선언부-전역변수는 초기화를 생성자가 해준다.
	Connection 			con 	= null;//전역변수 선언하기 - 클래스() 전역에서 사용가능함.
	//오라클 서버에 쿼리문을 전달하고 너가 좀 처리해 줄래
	PreparedStatement 	pstmt 	= null;
	//오라클에는 일꾼이 살고 있는데 이름은 옵티마이저라고 함.
	//데이터를 찾을 때는 커서를 움직이면서 조회결과가 존재하는지 확인하고 그 로우에 있는 값들을
	//RAM메모리 영역에 올린다.  커서를 조작하면서 해당 로우에 있는 값을 꺼낼 수 있다.
	ResultSet 		rs  		= null;
	JTextField 		jtf_dong 	= new JTextField("동이름을 입력하세요.");
	JButton 		jbtn_search = new JButton("조회");
	//오라클에서 조회한 결과를 담을 클래스 선언 및 생성하기
	//테이블의  헤더 설정하기
	String 			cols[]      = {"주소","우편번호"};
	String 		    data[][] 	= new String[0][2];
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
	//생성자 - 리턴타입이 없다. 클래스이름과 동일하다.
	public ZipCodeSearchApp() {
		zdos = getZDOList();
		jcb_zdo = new JComboBox(zdos);
		//인스턴스화를 할때마다 생성자도 같은 횟수만큼 호출이 일어난다.
		//new A()같이 했을때 객체가 RAM에 로딩(상주:기억)되면서 동시에 생성자가 호출됨.
		System.out.println("나는 파라미터가 없는 디폴트 생성자라고 해.");
		System.out.println("나는 인스턴스화 하면 자동으로 호출되는 거야.");
	}
	public ZipCodeSearchApp(String str, int i) {
	}
	//새로 고침 기능을 구현해 보자. - SELECT
	public void refreshData(String zDO,String myDong) {
		con = dbMgr.getConnection();
		System.out.println("refreshData호출 성공"+myDong+", "+zDO);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT address, zipcode");
		sql.append("  FROM zipcode_t");
		sql.append(" WHERE 1=1");
		if(zDO!=null && zDO.length()>0) {
			sql.append(" AND zdo=?");		
		}
		if(myDong!=null && myDong.length()>0) {
			sql.append(" AND dong LIKE '%'||?||'%'");		
		}
		int i=1;
		try {
			pstmt = con.prepareStatement(sql.toString());
			if(zDO!=null && zDO.length()>0) {
				pstmt.setString(i++, zDO);//?들어갈 동이름이 결정됨.
			}			
			if(myDong!=null && myDong.length()>0) {
				pstmt.setString(i++, myDong);//?들어갈 동이름이 결정됨.
			}
			System.out.println("sql:"+sql.toString());
			rs = pstmt.executeQuery();//오라클 서버에게 처리를 요청함.
			Vector<ZipCodeVO> v = new Vector<>();
			ZipCodeVO zcVOS[] = null; 
			ZipCodeVO zcVO = null; 
			while(rs.next()) {//커서 이동, 커서이동
				//System.out.println("while문 : " +rs.next());//커서이동
				zcVO = new ZipCodeVO();
				zcVO.setAddress(rs.getString("address"));
				zcVO.setZipcode(rs.getInt("zipcode"));
				v.add(zcVO);
			}
			zcVOS  = new ZipCodeVO[v.size()];
			v.copyInto(zcVOS);//벡터 자료구조에 들어있는 정보를 복사하기	
			System.out.println("v.size():"+v.size()+", "+zcVOS.length);
			if(v.size()>0) {//조회된 결과가 있니?
				while(dtm_zip.getRowCount() > 0) {
					dtm_zip.removeRow(0);
				}
			//조회결과가 있다면 데이터를 DefaultTableModel에 담아주어야 합니다.
			//그래야 JTable에서 그리드에 출력된 결과를 볼 수 있기 때문입니다.
			//그런데 컬럼을 하나씩 각각 개발자가 일일이 초기화 해주는 건 너무 불편합니다.
				for(int x=0;x<v.size();x++) {
			//그래서 for문 안에서 벡터를 하나 더 생성했어요 
			//addRow라는 메소드가 있는데 이 파라미터에 Vector를 넣으면 한개로우씩
			//추가 해준다고 합니다.		
					Vector oneRow = new Vector();
					oneRow.add(0, zcVOS[x].getAddress());
					oneRow.add(1, zcVOS[x].getZipcode());
					dtm_zip.addRow(oneRow);
				}
			}
		} catch (SQLException se) {
			//테이블이 존재하지 않습니다.-테이블을 만들지 않았네
			//혹은 부적합한 식별자 - 컬럼명이 맞지 않습니다.
			System.out.println("[[query]]"+sql);
		} catch(Exception e) {//그 밖에 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
	}
	//화면그리기
	public void initDisplay() {
		jcb_zdo.addItemListener(this);
		jtf_dong.addFocusListener(this);
		System.out.println("initDisplay 호출 성공");
		//테이블 헤더 영역에 배경색 바꿔볼까?
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
		jp_north.add(jcb_zdo);
		jp_north.add(jtf_dong);
		jp_north.add(jbtn_search);
		jbtn_search.addActionListener(this);
		jtf_dong.addActionListener(this);
		jf_zip.setTitle("우편번호 검색");
		//JFrame판넬 위에 북쪽에 jp_north속지를 붙이자.
		//속지 안에 버튼과 텍스트필드가 붙어 있으니까 같이 따라온다.
		jf_zip.add("North",jp_north);
		jf_zip.add("Center",jsp_zip);
		jf_zip.setSize(600, 500);
		jf_zip.setVisible(true);
	}
	//콤보박스에 뿌려질 ZDO 컬럼의 정보를 오라클 서버에서 꺼내오기
	public String[] getZDOList() {
		//리턴타입을 1차 배열로 했으므로 1차배열 선언하기
		String zdos[] = null;
		//오라클 서버에게 보낼 select문 작성하기
		//String은 원본이 바뀌지 않음.
		StringBuilder sb = new StringBuilder();
		//자바코드는 이클립스에서 디버깅하고 select문 토드에서 디버깅하기
		sb.append("SELECT '전체' zdo FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT zdo                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(zdo) zdo ");
		sb.append("          FROM zipcode_t         ");
		sb.append("        ORDER BY zdo asc         ");
		sb.append("       )                         ");
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {
//stack영역에 관리되는 에러메시지 정보를 라인번호와 이력까지 출력해줌.			
			e.printStackTrace();
		}
		return zdos;
	}
	//메인메소드
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ZipCodeSearchApp zipApp = new ZipCodeSearchApp();
		zipApp.initDisplay();
	}
	//
	@Override
	public void actionPerformed(ActionEvent ae) {
		//이벤트가 감지된 버튼의 주소번지를 읽어오는 메소드임.
		Object obj = ae.getSource();
		if((obj == jbtn_search)||(obj == jtf_dong)) {
			String myDong = jtf_dong.getText();
			//자바에서는 같은 이름의 메소드를 정의할 수 있다.
			//단 파라미터의 갯수가 다르거나 파라미터 타입이 반드시 달라야 한다.
			refreshData(zdo,myDong);			
		}
	}
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == jtf_dong) {
			jtf_dong.setText("");
		}
	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(obj == jcb_zdo) {
			if(ie.getStateChange() == ItemEvent.SELECTED) {
//오전에 테스트할 때 인덱스값이 0부터 이었나요?				
				System.out.println(zdos[jcb_zdo.getSelectedIndex()]);
				zdo = zdos[jcb_zdo.getSelectedIndex()];
			}
		}
	}
}//////////end of ZipCodeSearchApp





