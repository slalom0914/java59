package friday0207;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.util.DBConnectionMgr;

//화면을 이용해서 리턴타입과 파라미터 복습하기
public class LoginForm implements ActionListener {
	//선언부
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();//friendly상태는 서로 다른 패키지는 접근 불가
	JFrame jf_login 	= new JFrame();
	JPanel jp_first 	= new JPanel();
	//jp_first속지안에 서쪽에 jlb_id, 중앙에  jtf_id
	JLabel jlb_id		= new JLabel(" 아  이  디 ");
	JTextField jtf_id	= new JTextField();
	JPanel jp_second 	= new JPanel();
	JLabel jlb_pw		= new JLabel("  비밀번호 ");
	JTextField jtf_pw	= new JTextField();
	JPanel jp_third 	= new JPanel();
	JButton jbtn_login  = new JButton("로그인");
	//생성자
	LoginForm(){
		initDisplay();
	}
	//로그인 처리 메소드 구현
	public String[] login(String u_id, String u_pw) {
		String result[] = new String[2];
		String db_id = null;
		String mem_name = null;
		String status = null;
		StringBuilder sb = new StringBuilder("");
		StringBuilder sb2 = new StringBuilder("");
		try {
			sb.append(" SELECT                          ");
		    sb.append("       nvl((SELECT 1 FROM member5");
		    sb.append("             WHERE mem_id=?)     ");
		    sb.append("           ,-1) status           ");
		    sb.append(" FROM dual	                    ");
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {//조회가 결과가 있는거야?
				status = rs.getString("status");
			}
			System.out.println("status:"+status);
			if("1".equals(status)) {//아이디가 존재하니?
				sb2.append("SELECT                                ");
			    sb2.append("   NVL((SELECT mem_name       ");
			    sb2.append("          FROM member5                ");
			    sb2.append("         WHERE mem_id=?             ");
			    sb2.append("           AND mem_pw=?),0) mem_name");
			    sb2.append(" FROM dual				             ");
			    pstmt = null;
			    pstmt = con.prepareStatement(sb2.toString());
				pstmt.setString(1, u_id);
				pstmt.setString(2, u_pw);
				rs = null;
				rs = pstmt.executeQuery();
				if(rs.next()) {
					mem_name = rs.getString("mem_name");
					db_id = u_id;
					result[0] = mem_name;//첫번째 방에 이름을 담음.
					result[1] = db_id;//사용자가 입력한 아이디
				}
//아래에서 비밀번호가 맞지 않습니다. 메시지는 result배열에 담겨야 합니다.
//왜냐하면 리턴타입을 String에서 String[]로 바꾸었고 그 바뀐 정보를 if문에서 비교
//해야 하니까 더이상 mem_name에 값은 if문에서 역할이 없어진 것이죠.
//비밀번호가 맞지 않습니다.를 result[0]에 담아주어야 합니다.				
				if(mem_name.equals("0")) {
					result[0] = "비밀번호가 맞지 않습니다.";
				}
			}
			else if("-1".equals(status)){//아이디가 없는건가?
				result[0]="아이디가 존재하지 않습니다.";
			}
		} catch (Exception e) {
			//에러를 해결하기 위해서는 최대한 많은 힌트를 끌어 모아야 합니다.
			//에러메시지를 JVM이 stack영역에 관리하는데 그 이력과 라인번호를 같이
			//출력해줌.
			e.printStackTrace();//기억
			System.out.println("sql:"+sb.toString());
			System.out.println(e.toString());//예외가 발생되면 힌트를 얻을 수 있어요.
		}
		return result;
	}
	//화면처리부
	public void initDisplay() {
		//로그인 버튼을 눌렀을 때 이벤트 감지가 되면 actionPerformed메소드를 호출하는데
		//이 메소드를 구현하는 클래스와 연결하기
		jbtn_login.addActionListener(this);
		jf_login.setLayout(new GridLayout(3,1));
		jp_first.setBackground(Color.green);
		jp_first.setLayout(new BorderLayout());
		jp_first.setBorder(BorderFactory.createEtchedBorder());
		jp_first.add("West",jlb_id);
		jp_first.add("Center",jtf_id);
		jp_second.setBackground(Color.blue);
		jp_second.setLayout(new BorderLayout());
		jp_second.setBorder(BorderFactory.createEtchedBorder());
		jp_second.add("West",jlb_pw);
		jp_second.add("Center",jtf_pw);		
		jp_third.setBackground(Color.red);
		jp_third.setBorder(BorderFactory.createEtchedBorder());
		jp_third.add(jbtn_login);
		jf_login.add(jp_first);
		jf_login.add(jp_second);
		jf_login.add(jp_third);
		jf_login.setSize(255, 185);
		jf_login.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		new LoginForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//로그인 버튼을 누른거야?
		if(obj == jbtn_login) {
			String u_id = jtf_id.getText();//텍스트 필드에 입력한 아이디
			String u_pw = jtf_pw.getText();//텍스트필드에 입력한 비번
			String result[] = login(u_id,u_pw);
			System.out.println("mem_name : "+result[0]);
			if(result[0].equals("비밀번호가 맞지 않습니다.") 
			 ||result[0].equals("아이디가 존재하지 않습니다.")) {
				JOptionPane.showMessageDialog(jf_login, result[0]);
//if문에서 return을 만나면 그 메소드를 탈출 할 수 있다.				
				return;
			}
			else {
				new BaseBallGameView(result);
				jf_login.dispose();
			}
		}
	}

}




