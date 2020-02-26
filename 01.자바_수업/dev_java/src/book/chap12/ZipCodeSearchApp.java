package book.chap12;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.util.DBConnectionMgr;

import oracle.jdbc2.JDBCTest;
import oracle.jdbc2.ZipCodeVO;

public class ZipCodeSearchApp implements ItemListener, ActionListener, FocusListener {
	String zdos[] = null;
	String zdo = null;
	JComboBox jcb_zdo = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection 			con 	= null;//전역변수 선언하기 - 클래스() 전역에서 사용가능함.
	PreparedStatement 	pstmt 	= null;
	ResultSet 		rs  		= null;
	JTextField 		jtf_dong 	= new JTextField("동이름을 입력하세요.");
	JButton 		jbtn_search = new JButton("조회");
	JButton 		jbtn_del 	= new JButton("삭제");
	String 			cols[]      = {"주소","우편번호"};
	String 		    data[][] 	= new String[0][2];
	DefaultTableModel dtm_zip	= new DefaultTableModel(data,cols);
	JTable		    jt_zip 		= new JTable(dtm_zip);
	JScrollPane     jsp_zip		= new JScrollPane(jt_zip);
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
	public List<Map<String,Object>> refreshData(String zDO,String myDong) {
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
		List<Map<String,Object>> addrList = new ArrayList<>();
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
			Map<String,Object> rMap = null; 
			while(rs.next()) {//커서 이동, 커서이동
				//System.out.println("while문 : " +rs.next());//커서이동
				rMap = new HashMap<>();
				rMap.put("address",rs.getString("address"));
				rMap.put("zipcode",rs.getInt("zipcode"));
				addrList.add(rMap);
			}
			System.out.println("addrList.size():"+addrList.size());
			if(addrList.size()>0) {//조회된 결과가 있니?
				while(dtm_zip.getRowCount() > 0) {
					dtm_zip.removeRow(0);
				}
				for(int x=0;x<addrList.size();x++) {	
					Map<String,Object> map = addrList.get(x);
					Vector oneRow = new Vector();
					oneRow.add(0, map.get("address"));
					oneRow.add(1, map.get("zipcode"));
					dtm_zip.addRow(oneRow);
				}
			}
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql);
		} catch(Exception e) {//그 밖에 문제가 발생할 경우 잡아준다.
			System.out.println("[[Exception]]"+e);
		}
		return addrList;
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
		jp_north.add(jbtn_del);
		jbtn_search.addActionListener(this);
		jbtn_del.addActionListener(this);
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
		else if(obj == jbtn_del) {
			int index[] = jt_zip.getSelectedRows();
			for(int row:index) {
				JOptionPane.showMessageDialog(jf_zip, row);
			}
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





