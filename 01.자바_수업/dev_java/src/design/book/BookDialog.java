package design.book;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BookDialog extends JDialog implements ActionListener {
/*
 * 자녀창에서 저장(입력) 성공했을때 부모창의 refreshData를 호출해야 한다.
 * 그런데 원본을 재사용해야 하므로 set메소드의 파라미터로 받아서 사용할 것이다.
 * 다른 메소드에서 ba를 사용해야 하니까 전역변수로 선언한 다음 초기화를 반드시 할것.	
 */
	String imgPath = "src\\design\\book\\";
	//도서이미지 추가해 보기
	ImageIcon icon = null;	
	BookApp ba = null;
	boolean isView = false;
	String title = null;//입력
	//인스턴스화를 하면 생성자 호출이 일어남.
	JLabel jlb_name = new JLabel("도서명");
	JTextField jtf_name = new JTextField(20);
	JLabel jlb_author = new JLabel("저자");
	JTextField jtf_author = new JTextField(20);
	JLabel jlb_publish = new JLabel("출판사");
	JTextField jtf_publish = new JTextField(20);
	JLabel jlb_info = new JLabel("도서소개");
	JTextArea jta_info = new JTextArea(8,25);
	JScrollPane jsp_info = new JScrollPane(jta_info);
	JButton jbtn_file = new JButton("파일찾기");
	JTextField jtf_file = new JTextField(30);
	//insert here
	JLabel jlb_img = new JLabel("이미지없음");
	JPanel jp_center = new JPanel();
	JPanel jp_south  = new JPanel();
	JButton jbtn_save 	= new JButton("저장");
	JButton jbtn_close 	= new JButton("닫기");
	JScrollPane jsp = new JScrollPane(jp_center);
	JFileChooser jfc = new JFileChooser();
	BookVO rbVO = null;
	Container cont = this.getContentPane();
	public BookDialog() {
		jbtn_file.addActionListener(this);
		jbtn_save.addActionListener(this);
		jbtn_close.addActionListener(this);
	}
	//입력과 수정시에는 컬럼값을 수정 가능하도록 하고
	//조회시에는 불가능하게 하는 메소드를 선언해 봐요.
	public void setEditable(boolean isOk) {
		jtf_name.setEditable(isOk);
		jtf_author.setEditable(isOk);
		jtf_publish.setEditable(isOk);
		jta_info.setEditable(isOk);
	}
	/****************************************************************
	 * 
	 * @param title 다이얼로그창 제목
	 * @param isView 다이얼로그창 뷰 여부
	 * @param editable 입력 컴포넌트 수정 여부
	 * @param rMap 조회결과를 담은 주소번지
	 ***************************************************************/
	public void set(String title, boolean isView, boolean editable, Map<String,Object> rMap, BookApp ba)
	{
		this.ba = ba;
		setValue(rMap);
		setEditable(editable);
		this.setTitle(title);
		initDisplay();
		this.setVisible(isView);
	}	
	/************************************************************
	 * 
	 * @param title 입력|수정|상세조회
	 * @param isView true:화면에 보여줌 false:안보여줌.
	 * @param editable true:수정하게해줌, false:수정못하게함
	 * @param rbVO null이면 값 없음 , rbVO[new BookVO]이면 값 있음
	 * @param ba BookApp의 주소번지 원본을 가지고 있음.
	 ************************************************************/
	public void set(String title, boolean isView
			      , boolean editable, BookVO rbVO, BookApp ba) {
		this.ba = ba;
		this.rbVO = rbVO;
		setValue(rbVO);
		setEditable(editable);
		this.setTitle(title);
		initDisplay();
		this.setVisible(isView);
	}
	//조회된 결과를 BookDialog에 초기화 하기
	//새로 입력하는 경우에는 빈 문자열로 초기화 하기
	/*******************************************************
	 * BookApp에서 조회된 한 건을 BookDialog에 초기화함.
	 * @param rmap 조회된 한건을 Map으로 받은 경우
	 ******************************************************/
	public void setValue(Map<String,Object> rmap) {
	//입력을 위한 화면 설정 - 모든값을 빈문자열로 셋팅한다.
		if(rmap == null) {
			setB_name("");
			setB_author("");
			setB_publish("");
			setB_info("");
		}
	//상세조회와 수정시는  파라미터로 받은 값으로 셋팅한다.
	//처음 설계시에는 맵으로 했던걸 어제 bVO로 추가 처리함.	
		else {
			/*
			setB_name(rmap.get("b_name").toString());
			setB_name(rmap.get("b_name").toString());
			setB_name(rmap.get("b_name").toString());
			setB_name(rmap.get("b_name").toString());
			*/
		}
	}	
	/*******************************************************
	 * BookApp에서 조회된 한 건을 BookDialog에 초기화함.
	 * @param rbVO 조회된 한건을 BookVO로 받은 경우
	 ******************************************************/	
	private void setValue(BookVO rbVO) {
		//입력을 위한 화면 설정 - 모든값을 빈문자열로 셋팅한다.
		if(rbVO == null) {
			setB_name("");
			setB_author("");
			setB_publish("");
			setB_info("");
			setB_img("");//새로 이미지를 초이스 해야 하니까 비워둔다.
		}
	//상세조회와 수정시는  파라미터로 받은 값으로 셋팅한다.
		else {
			setB_name(rbVO.getB_name());
			setB_author(rbVO.getB_author());
			setB_publish(rbVO.getB_publish());
			setB_info(rbVO.getB_info());
			setB_img(rbVO.getB_img());
		}
	}
	public void initDisplay() {
		//TextArea에 자동 줄바꿈 처리해보기
		jta_info.setLineWrap(true);
		//속지에 레이아웃이 FlowLayout이었던 것을 null로 초기화함.
		jp_center.setLayout(null);//좌표값으로 배치할거야
		jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp_south.add(jbtn_save);
		jp_south.add(jbtn_close);
		//화면에 배치할 때 setBounds(x좌표,y좌표,가로길이,세로길이)
		//앞에 두 자리가 시작점 좌표값 20,20-시작점
		//세번째 네번째가 가로세로결정 100,20 가로길이와 세로길이
		jlb_name.setBounds(20, 20, 100, 20);
		jtf_name.setBounds(120, 20, 200, 20);
		jlb_author.setBounds(20, 45, 100, 20);
		jtf_author.setBounds(120, 45, 120, 20);
		jlb_publish.setBounds(20, 70, 100, 20);
		jtf_publish.setBounds(120, 70, 150, 20);
		jlb_info.setBounds(20, 95, 100, 20);
		jsp_info.setBounds(120, 95, 300, 160);
		jbtn_file.setBounds(20, 260, 90, 20);
		jtf_file.setBounds(120, 260, 350, 20);
		jlb_img.setBorder(BorderFactory.createEtchedBorder());
		jlb_img.setBounds(120, 285, 300, 360);
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		jp_center.add(jlb_author);
		jp_center.add(jtf_author);
		jp_center.add(jlb_publish);
		jp_center.add(jtf_publish);
		jp_center.add(jlb_info);
		jp_center.add(jsp_info);
		jp_center.add(jbtn_file);
		jp_center.add(jtf_file);
		jp_center.add(jlb_img);
		this.add("Center",jsp);
		this.add("South",jp_south);
		this.setSize(500, 720);
		//this.setVisible(true);
		//부모창에서 선택한 버튼에 따라 화면을 제어한다.- 변수
	}

	//각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드 입니다.
	public String getB_name() {	return jtf_name.getText();}
	public void setB_name(String name) { jtf_name.setText(name);}
	public String getB_author() {	return jtf_author.getText();}
	public void setB_author(String author) { jtf_author.setText(author);}
	public String getB_publish() {	return jtf_publish.getText();}
	public void setB_publish(String publish) { jtf_publish.setText(publish);}
	public String getB_info() {	return jta_info.getText();}
	public void setB_info(String info) { jta_info.setText(info);}
	//JLabel에 도서 이미지 출력하기
	public void setB_img(String img) {
		icon = new ImageIcon(imgPath+img);
		//원본의 이미지 크기 정보를 가져온다. -79
		Image originImg = icon.getImage();//458*626
		//458*626이미지 크기를 가져와서 300*380 이미지 크기로 재정의
		Image changeImg = 
				originImg.getScaledInstance(300, 380
						, Image.SCALE_SMOOTH);//300*380
		//원본의 이미지 아이콘 icon -> cicon으로 변경 처리->> 적용됨.
		//원래 있던 이미지 아이콘을 버리고 새로운 ImageIcon객체를 인스턴스화 하였다.
		ImageIcon cicon = new ImageIcon(changeImg);
		//JLabel에 setIcon이라는 메소드의 파라미터로 넘겨서 적용시킨다.
		jlb_img.setIcon(cicon);		
	}
	/*	*/ 
	public static void main(String[] args) {
		BookDialog bd = new BookDialog();
		bd.set("입력",true,true,new BookVO(),null);
		bd.initDisplay();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();//이벤트 소스의 라벨
		//JOptionPane.showMessageDialog(ba, "이벤트 소스 라벨:"+command);
		if(jbtn_file == e.getSource()) {
			int ir = jfc.showOpenDialog(this);
			if(ir == JFileChooser.APPROVE_OPTION) {
			//선택한 파일을 File객체에 대입
				File myFile = jfc.getSelectedFile();
				//절대경로를 가져온다.<-> 상대경로:내가 바라보는 위치를 기준으로 적음
				//D:\59기수업\01.자바_수업
				jtf_file.setText(myFile.getAbsolutePath());
				String cfile = myFile.getAbsolutePath();
				icon = new ImageIcon(cfile);
				//원본의 이미지 크기 정보를 가져온다. -79
				Image originImg = icon.getImage();//458*626
				//458*626이미지 크기를 가져와서 300*380 이미지 크기로 재정의
				Image changeImg = 
						originImg.getScaledInstance(300, 380
								, Image.SCALE_SMOOTH);//300*380
				//원본의 이미지 아이콘 icon -> cicon으로 변경 처리->> 적용됨.
				//원래 있던 이미지 아이콘을 버리고 새로운 ImageIcon객체를 인스턴스화 하였다.
				ImageIcon cicon = new ImageIcon(changeImg);
				//JLabel에 setIcon이라는 메소드의 파라미터로 넘겨서 적용시킨다.
				jlb_img.setIcon(cicon);	
				cont.revalidate();
			}
		}
		//저장버튼을 누른거니?
		else if("저장".equals(command)) {
			//insert here - 입력 인지 수정인지 어떻게 구분하지?
			int result = 0;
			//rbVO는 BookVO타입으로 BookApp에서 이벤트 발생시 set메소드의 
			//4번째 파라미터로 넘어온 값이다.
			//이 주소번지가 null이면 조회를 하지 않았다는 뜻이고
			//null이 아니면 조회를 하였다는 의미
			if(rbVO!=null) {//수정처리하기
				BookVO pbVO = new BookVO();
				pbVO.setCommand("update");
				pbVO.setB_no(rbVO.getB_no());//입력한 도서명 가져오기
				pbVO.setB_name(getB_name());//입력한 도서명 가져오기
				pbVO.setB_author(getB_author());//저자이름
				pbVO.setB_publish(getB_publish());//출판사
				pbVO.setB_info(getB_info());//출판사
			    result=ba.bDao.bookUpdate(pbVO);				
			}else {//입력처리하기
				BookVO pbVO = new BookVO();
				pbVO.setB_name(getB_name());//입력한 도서명 가져오기
				pbVO.setB_author(getB_author());//저자이름
				pbVO.setB_publish(getB_publish());//출판사
				pbVO.setB_info(getB_info());//출판사
			    result=ba.bDao.bookInsert(pbVO);
			    JOptionPane.showMessageDialog(ba, "reuslt:"+result);
			}
			ba.refreshData();
			this.dispose();
		}
		//닫기 버튼을 눌렀니?
		else if("닫기".equals(command)) {
			this.dispose();
		}
	}
}






