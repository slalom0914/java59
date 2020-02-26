package design.book;

import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookDialog extends JDialog {
	boolean isView = false;
	String title = null;//입력
	//인스턴스화를 하면 생성자 호출이 일어남.
	JLabel jlb_title = new JLabel("책제목");
	JTextField jtf_title = new JTextField(20);
	public BookDialog() {
	}
	//입력과 수정시에는 컬럼값을 수정 가능하도록 하고
	//조회시에는 불가능하게 하는 메소드를 선언해 봐요.
	public void setEditable(boolean isOk) {
		jtf_title.setEditable(isOk);
	}
	/****************************************************************
	 * 
	 * @param title 다이얼로그창 제목
	 * @param isView 다이얼로그창 뷰 여부
	 * @param editable 입력 컴포넌트 수정 여부
	 * @param rMap 조회결과를 담은 주소번지
	 ***************************************************************/
	public void set(String title, boolean isView, boolean editable, Map<String,Object> rMap)
	{
		setValue(rMap);
		setEditable(editable);
		this.setTitle(title);
		initDisplay();
		this.setVisible(isView);
	}	
	public void initDisplay() {
		this.setLayout(null);
		jlb_title.setBounds(20, 20, 100, 20);
		jtf_title.setBounds(120, 20, 150, 20);
		this.add(jlb_title);
		this.add(jtf_title);
		this.setSize(500, 450);
		//부모창에서 선택한 버튼에 따라 화면을 제어한다.- 변수
	}
	public void setValue(Map<String,Object> rmap) {
	//입력을 위한 화면 설정 - 모든값을 빈문자열로 셋팅한다.
		if(rmap == null) {
			setB_title("");
		}
	//상세조회와 수정시는  파라미터로 받은 값으로 셋팅한다.
		else {
			setB_title(rmap.get("b_title").toString());
		}
	}
	//각 컬럼의 값들을 설정하거나 읽어오는 getter/setter메소드 입니다.
	public String getB_title() {	return jtf_title.getText();}
	public void setB_title(String title) { jtf_title.setText(title);}
	/*		
	public static void main(String[] args) {
		BookDialog bd = new BookDialog();
		bd.set("입력",true,null);
		//bd.initDisplay();
	}
	 */
}






