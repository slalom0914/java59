package design.book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;


public class BookApp extends JFrame implements ActionListener {
	//선언부
	//DB커넥션 연결하기
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//이미지 경로 추가
	String imgPath = "src\\design\\book\\";
	URL bookURL = getClass().getResource("book.png");
	ImageIcon bicon = new ImageIcon(bookURL);
	//메뉴바 추가하기
	JMenuBar 	jmb_book 	= new JMenuBar();
	JMenu    	jm_file		= new JMenu("File");
	JMenuItem	jmi_db   	= new JMenuItem("DB연결");
	JMenuItem	jmi_open	= new JMenuItem("Open File");
	JSeparator  js_file		= new JSeparator();
	JMenuItem	jmi_exit	= new JMenuItem("Exit");
	JMenu    	jm_edit		= new JMenu("Edit");
	JMenuItem   jmi_all		= new JMenuItem("전체조회");
	JMenuItem   jmi_sel		= new JMenuItem("상세조회",new ImageIcon(imgPath+"detail.gif"));
	JMenuItem   jmi_ins		= new JMenuItem("입력",new ImageIcon(imgPath+"new.gif"));
	JMenuItem   jmi_upd		= new JMenuItem("수정",new ImageIcon(imgPath+"update.gif"));
	JMenuItem   jmi_del		= new JMenuItem("삭제",new ImageIcon(imgPath+"delete.gif"));
	static BookApp ba = null;
	//파라미터가 없는 생성자는 디폴트로 지원해주지만 있는 경우는 예측불가이므로 지원불가함.
	BookDialog bd = new BookDialog();
	//jp_north속지는 JFrame의 북쪽에 배치
	JPanel jp_north = new JPanel();
	//아래 버튼은 jp_north속지에 차례대로 배치-배치는 왼쪽부터 
	JToolBar jtbar	 = new JToolBar();
	JButton jbtn_db  = new JButton("DB연결");
	JButton jbtn_all = new JButton("전체조회");
	JButton jbtn_sel = new JButton();
	JButton jbtn_ins = new JButton();
	JButton jbtn_upd = new JButton();
	JButton jbtn_del = new JButton();
	JLabel jlb_time = new JLabel("현재시간",JLabel.CENTER);
	TimeClient tc = null;
	String cols[] 	= {"도서번호","도서명","저자","출판사"};
	String data[][] = new String[0][4];
	DefaultTableModel dtm_book = new DefaultTableModel(data, cols);
	JTable jtb_book = new JTable(dtm_book);
	JScrollPane jsp_book = new JScrollPane(jtb_book);
	BookDao bDao = new BookDao();
	BookController bCtrl = new BookController(this);
	//이벤트 소스와 이벤트 핸들러 클래스 연결하기
	public void eventMapping() {
		//db연결 버튼 이벤트 처리
		jbtn_db.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
			}
		});
		//db연결 메뉴 아이템 이벤트 처리
		jmi_db.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dbActionPerformed(ae);
			}
		});
	}
	protected void dbActionPerformed(ActionEvent ae) {
		System.out.println("db연결 테스트");
		Connection con = null;
		con = dbMgr.getConnection();
		System.out.println(con.toString());
	}
	//화면 그리기
	public void initDisplay() {
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		jm_file.add(jmi_db);
		jm_file.add(jmi_open);
		jm_file.add(js_file);
		jm_file.add(jmi_exit);
		jm_edit.add(jmi_all);
		jm_edit.add(jmi_sel);
		jm_edit.add(jmi_ins);
		jm_edit.add(jmi_upd);
		jm_edit.add(jmi_del);
		jmb_book.add(jm_file);
		jmb_book.add(jm_edit);
		this.setJMenuBar(jmb_book);
		//실제로 타임서버로 부터 시간정보를 듣기는 TimeClient에서 진행되지만
		//생성자의 파라미터를 통해서 BookApp jlb_time 원본의 주소번지를
		//넘겼으므로 TimeClient에서는 원본에 직접 써주면 화면에 보임.
		//tc = new TimeClient(jlb_time);
		//tc.start();
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
		jbtn_sel.setIcon(new ImageIcon(imgPath+"detail.gif"));
		jbtn_sel.setToolTipText("상세조회");
		jbtn_ins.setToolTipText("입력");
		jbtn_upd.setToolTipText("수정");
		jbtn_del.setToolTipText("삭제");
		jbtn_ins.setIcon(new ImageIcon(imgPath+"new.gif"));
		jbtn_upd.setIcon(new ImageIcon(imgPath+"update.gif"));
		jbtn_del.setIcon(new ImageIcon(imgPath+"delete.gif"));
		jtbar.add(jbtn_db);
		jtbar.add(jbtn_all);
		jtbar.add(jbtn_sel);
		jtbar.add(jbtn_ins);
		jtbar.add(jbtn_upd);
		jtbar.add(jbtn_del);
		this.add("North",jtbar);
		this.add("Center", jsp_book);
		this.add("South",jlb_time);
		this.setSize(700, 500);
		this.setIconImage(bicon.getImage());
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		TimeServer ts = new TimeServer();
		//ts.initDisplay();//화면을 그리고 난 뒤 스레드 대기를 타도록 해야함.
		//Thread th = new Thread(ts);
		//th.start();//스레드의 run메소드를 호출하는 메소드		
		//insert here
		ba = new BookApp();
		ba.initDisplay();//화면처리 부분
		ba.eventMapping();//이벤트 연결-익명클래스 처리
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
			BookVO bVO = null;
			bd.set("입력", true, true, bVO, ba);
			//initDisplay를 호출한 이유는 setTitle("입력")과 setVisible(true)
			//때문이었다. 그런데 그  둘을 set메소드로 이전하였다.
		}
		else if(jbtn_upd==obj) {//수정시에는 먼저 기본 정보를 조회하고 화면이동
			System.out.println("수정호출 성공");
			//insert here
			//select처리한 후 한 개 로우를 받아서 Map에 저장
			BookVO rbVO = null;
			int index = -1;
			index = jtb_book.getSelectedRow();
			if(index >=0) {//선택한 로우값이 있다.
				//파라미터로 도서번호를 넘겨야 한다.
				BookVO pbVO = new BookVO();
				pbVO.setCommand("detail");
				int b_no = Integer.parseInt(
						dtm_book.getValueAt(index, 0).toString());
				pbVO.setB_no(b_no);
				rbVO = bCtrl.send(pbVO);
			}else {//선택한 로우가 없다.
				JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요");
				return;//actionPerformd를 탈출함.				
			}
			bd.set("수정", true, true, rbVO, ba);
		}
		else if(jbtn_sel==obj) {
			System.out.println("상세조회호출 성공");
			//insert here
			Map<String,Object> rMap = null;
			int indexs[] = jtb_book.getSelectedRows();
			if(indexs.length==0) {
				JOptionPane.showMessageDialog
				(this, "상세조회할 로우를 선택하세요.");
				return;
			}
			else {
				int b_no = Integer.parseInt(
						dtm_book.getValueAt(indexs[0], 0).toString());
				//System.out.println("b_no : "+b_no);//2
				BookVO pbVO = new BookVO();
				pbVO.setCommand("detail");
				pbVO.setB_no(b_no);
				System.out.println("command:"+pbVO.getCommand());
				System.out.println("b_no:"+pbVO.getB_no());
				BookVO rbVO = bCtrl.send(pbVO);
				bd.set("상세보기", true, false, rbVO, null);
			}
			//bd.set(jbtn_sel.getText(), true, false, rMap, null);
		}
		else if(jbtn_del==obj) {
			System.out.println("삭제호출 성공");
			int indexs[] = jtb_book.getSelectedRows();
			if(indexs.length==0) {
				JOptionPane.showMessageDialog
				(this, "삭제할 로우를 선택하세요.");
				return;
			}else {
				List<Integer> bnos = new ArrayList<>();
				for(int i=0;i<dtm_book.getRowCount();i++) {
					//선택된 로우인지 체크
					if(jtb_book.isRowSelected(i)) {
						int b_no = Integer.parseInt(
								dtm_book.getValueAt(i, 0).toString());						
						bnos.add(b_no);
					}
				}
				BookVO pbVO = new BookVO();
				pbVO.setCommand("delete");//command="delete"
				pbVO.setBnos(bnos);//List담았다.
				int result = 0;
				BookVO rbVO = new BookVO();				
				rbVO = bCtrl.send(pbVO);
				result = rbVO.getResult();
				if(result>0) {
					JOptionPane.showMessageDialog(this, "삭제 처리되었습니다.");
					refreshData();
				}
				else {
					JOptionPane.showMessageDialog(this, "실패하였습니다.");
					refreshData();
				}
			}
		}
		else if(jbtn_all==obj) {
			System.out.println("전체 조회 호출 성공");
			refreshData();
		}		
	}

	public void refreshData() {
		System.out.println("refreshData 호출 성공");
		List<BookVO> bookList = null;
		BookVO pbVO = new BookVO();
		pbVO.setCommand("all");
		bookList = bCtrl.sendALL(pbVO);
		//기존에 조회된 결과를 출력한 화면은 삭제처리한다.
		while(dtm_book.getRowCount()>0) {//bookList.size() 숫자와 동일
			dtm_book.removeRow(0);//계속 로우수만큼 반복하면서 첫번째 로우 즉 0번 계속 지워준다.
		}
		//삭제한 후 다시 출력하기
		for(int i=0;i<bookList.size();i++) {
			BookVO bVO = bookList.get(i);
			Vector<Object> v = new Vector<>();
			v.add(bVO.getB_no());
			v.add(bVO.getB_name());
			v.add(bVO.getB_author());
			v.add(bVO.getB_publish());
			//JTable에 추가하는 것이 아니다.-JTable은 양식일 뿐이고
			//실제 데이터를 갖는 클래스는 DefaultTableModel이다.-DataSet지원함.
			//한개로우는 Vector에 담고 그 벡터를 for문 안에서 반복 추가해줌.
			dtm_book.addRow(v);
		}
	}//////////////end of refreshData
}











