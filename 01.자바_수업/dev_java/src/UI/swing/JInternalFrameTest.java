package UI.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class JInternalFrameTest implements ActionListener{
	JFrame jf = new JFrame();
	//이 아이를 중앙에 배치하고 JInternalFrame으로 내부에 띄워줄 창을 만들면
	//JFrame창 안에 여러개의 내부창을 관리할 수 있다.
	JDesktopPane jdp 	= new JDesktopPane();
	JPanel jp_north 	= new JPanel();
	JButton jbtn_zip 	= new JButton("우편번호찾기");
	JButton jbtn_order 	= new JButton("주문목록");
	JButton jbtn_dept 	= new JButton("부서목록");
	JButton jbtn_emp 	= new JButton("사원목록");
	public JInternalFrameTest() {
		initDisplay();
	}
	public void initDisplay() {
		//내 안에 actionPerformed메소드를 구현하였다.
		//이 코드가 있어야 자동(누가? JVM)으로 actionPerformed메소드를 호출해줌. 
		jbtn_zip.addActionListener(this);//
		jbtn_order.addActionListener(this);//
		jbtn_dept.addActionListener(this);//
		jbtn_emp.addActionListener(this);//
		jf.setTitle("윈도우창에 내부 프레임 생성하기");
		//jp_north속지에 우편번호 찾기 버튼을 오른쪽에서 부터 붙인다.
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_zip);
		jp_north.add(jbtn_order);
		jp_north.add(jbtn_dept);
		jp_north.add(jbtn_emp);
		//북쪽에는 jp_north속지를 붙여 줄까
		jf.add("North",jp_north);
		//jf의 중앙에 JDesktopPane속지를 붙여줄래
		jf.add("Center",jdp);
		jf.setSize(700, 500);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new JInternalFrameTest();
	}////////////end of main
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_zip) {
			//System.out.println("우편번호 찾기 호출 성공");
			InnerFrame inn = 
					new InnerFrame(jbtn_zip.getText()
							      ,true
							      ,true
							      ,true
							      ,true);
			jdp.add(inn);
		}
	}///////////end of actionPerformed
}
class InnerFrame extends JInternalFrame{
	InnerFrame(String title, boolean resizable
			  ,boolean closable,boolean maximizable
			  ,boolean iconifiable)
	{
		//아빠 생성자 호출 문장 - 아빠객체가 가진 기능들을 온전히 누릴 수 있다.
		super(title,resizable,closable,maximizable,iconifiable);
		this.setTitle(title);
		this.setSize(300, 200);
		this.setVisible(true);
	}
}







