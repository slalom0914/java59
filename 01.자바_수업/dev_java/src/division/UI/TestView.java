package division.UI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestView extends JFrame {
	TestSouth ts = new TestSouth();
	JPanel jp_north = new JPanel();
	JButton jbtn_change = new JButton("변경");
	//ts를 넘기면 TestSouth만 누릴 수 있지만 this를 넘기면  TestView와 TestSouth
	//모두를 누릴 수 있다.
	TestEvent te = new TestEvent(this);
	//TestSouth ts2 = new TestSouth(this);
	public TestView(){
		initDisplay();
	}
	public void initDisplay() {
		//코드의 가독성이 좋아짐.
		ts.jtf_msg.addActionListener(te);
		jbtn_change.addActionListener(te);
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_north.add(jbtn_change);
		this.add("North",jp_north);
		this.add("South",ts);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TestView();
	}

}
