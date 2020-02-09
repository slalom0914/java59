package book.chap05;

import javax.swing.JButton;

public class JButtonTest {

	public static void main(String[] args) {
		JButton jbtns[] = new JButton[4];
		String ss[] = new String[4];
		ss[0] = new String("오늘 괜찮아?");
		for(String s:ss) {
			System.out.println(s);
		}
		JButton jbtn_sel = new JButton("조회");
		JButton jbtn_ins = new JButton("입력");
		JButton jbtn_upd = new JButton("수정");
		JButton jbtn_del = new JButton("삭제");
		jbtns[0] = jbtn_sel;
		jbtns[1] = jbtn_ins;
		jbtns[2] = jbtn_upd;
		jbtns[3] = jbtn_del;
		for(JButton jbtn:jbtns) {
			System.out.println(jbtn);//null,null,null,null
		}
	}

}
