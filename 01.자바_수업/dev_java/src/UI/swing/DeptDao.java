package UI.swing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class DeptDao {
	//오라클 서버와 연결통로를 만드는데 필요한 인터페이스 입니다.
	Connection con = null;
	//연결통로가 만들어지면 그 길을 따라 select문을 오라클에게 전달해 줄 클래스가 필요하죠
	//그 아이가  PreparedStatment입니다.
	PreparedStatement pstmt = null;
	//조회결과를 오라클 서버로 부터 꺼내려면 커서가 필요한데 그 커서를 조작할 수 있도록
	//자바에서 제공되는 인터페이스가 ResultSet입니다.
	ResultSet rs = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//메소드의 리턴 타입은 배열로 했어요. 왜냐하면 그 배열을 JComboBox에 생성자 
	//파라미터로 넘겨야 하기 때문에 리턴타입이 꼭 필요한거죠.
	public String[] getDeptList() {
		//부서명을 담을 배열을 선언했어요. 그런데 생성하는 건 안될거 같아요.
		//왜냐하면 오라클에서 꺼낸값이 몇건인지 알아야 배열의 크기를 정할 수 있기 때문입니다.
		String depts[] = null;
		//쿼리문을 작성할 때 여러 로우가 나올 수 있는데 String을 사용하면 원본이 바뀌지
		//않아서 자바성능튜닝팀에서 못쓰게 합니다.
		//대신 StringBuilder를 사용하라고 권장하죠
		//이 클래스는 원본이 바뀌기 때문에 불필요한 자원낭비를 막을 수 있데요.
		//서버 입장에서는 동시 접속자 수가 많아서 작은 양이지만 큰 문제를 일으킬 수도 있다고
		//합니다.
		StringBuilder sb = new StringBuilder();
		//쿼리문작성하기
		sb.append("SELECT dname FROM dept");
		//예외가 발생되면 시스템이 멈춰 서 있게 됩니다.
		//무한히 기다리는 상황이 발생되므로 다음 사람도 이용할 수 없다.
		try {//물리적으로 떨어져 있는 서버에 ip주소로 접근하니까 예외가 발생할 가능성이 있음.
			//
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			//커서를 한줄씩 넘기면서 커서위치에 값을 변수에 담는다.
			while(rs.next()) {
				String dname = rs.getString("dname");
				//조회된 값을 벡터 클래스에 추가한다.
				v.add(dname);
			}
			//오라클 서버에서 조회된 결과 만큼 추가된 벡터의 크기값을 가지고
			//배열을 생성한다.
			depts = new String[v.size()];
			//벡터에 들어 있는 정보를 String배열에 복사한다.
			v.copyInto(depts);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return depts;
	}
	public static void main(String[] args) {
		DeptDao dd = new DeptDao();
		String depts[] = dd.getDeptList();
		for(String dept:depts) {
			System.out.println(dept);
		}
	}

}







