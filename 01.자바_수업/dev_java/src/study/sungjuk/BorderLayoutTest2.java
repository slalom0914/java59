package study.sungjuk;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderLayoutTest2 {
	JFrame jf = new JFrame();//디폴트 레이아웃이 BorderLayout[동,서,남,북,중앙]
	JPanel jp_north = new JPanel();
	JLabel jlb_su	= new JLabel("인원수");
	JLabel jlb_su2	= new JLabel("인원수");
	JLabel jlb_inwon= new JLabel("명");
	JTextField jtf_inwon = new JTextField();
	JTextField jtf_inwon2 = new JTextField(15);
	JPanel jp_south = new JPanel();//디폴트 레이아웃이 FlowLayout
	JPanel jp_west 	= new JPanel();
	JPanel jp_east 	= new JPanel();
	JPanel jp_center= new JPanel();
	public BorderLayoutTest2() {
		//원래 FlowLayout이었는데 이것을 BorderLayout으로 변경하기
		jp_north.setLayout(new BorderLayout());
		jp_north.setBackground(Color.yellow);
		jp_south.setBackground(Color.green);
		jp_south.setLayout(new FlowLayout(FlowLayout.LEFT));
		jp_south.add(jlb_su2);
		jp_south.add(jtf_inwon2);
		jp_south.add(jlb_inwon);
		jp_center.setBackground(Color.red);
		jp_west.setBackground(Color.blue);
		jp_east.setBackground(Color.pink);
		jp_north.add("West",jlb_su);
		jp_north.add("Center",jtf_inwon);
		jf.add("North",jp_north);
		jf.add("South",jp_south);
		jf.add("West",jp_west);
		jf.add("East",jp_east);
		jf.add("Center",jp_center);
		jf.setSize(500, 400);
		//화면에 JFrame을 출력해주세요.
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutTest2();
	}

}
