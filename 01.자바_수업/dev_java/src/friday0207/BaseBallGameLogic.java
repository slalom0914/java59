package friday0207;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.util.DBConnectionMgr;

public class BaseBallGameLogic {
	Connection con = null;//물리적으로 떨어져있는 서버와 연결통로 만들기
	PreparedStatement pstmt = null;//동적쿼리 작성하기 - ?
	//싱글톤 패턴을 활용화여 객체 주입받기 - 하나로 나누어 쓴다.
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	//컴터가 채번한 숫자를 담는 배열
	int com[] = new int[3];
	//사용자가 입력한 숫자를 담는 배열
	int my[] = new int[3];
	public int history(BaseballVO bVO) {
		String sql = "";
		sql+="insert into baseball(game_no, game_seq,game_date";
        sql+="        ,input, hint, dap                       ";
        sql+="        ,score, mem_id)                         ";
        sql+="  values(seq_baseball.nextval                   ";
        sql+="        ,?,to_char(sysdate,'YYYY-MM-DD')        ";
        sql+="        ,?,?,?,?,?)		  ";
        int result = 0;//1이면 입력 성공 0이면 입력 실패
        try {
			//insert here
        	con = dbMgr.getConnection();
        	pstmt = con.prepareStatement(sql);
        	pstmt.setInt(1, bVO.getGame_seq());
        	pstmt.setString(2, bVO.getInput());
        	pstmt.setString(3, bVO.getHint());
        	pstmt.setString(4, bVO.getDap());
        	pstmt.setInt(5, bVO.getScore());
        	pstmt.setString(6, bVO.getMem_id());
        	//1row inserted
        	result = pstmt.executeUpdate();//위에서 작성한 insert문 처리해주세요.
        	if(result ==1) System.out.println("입력 성공");
        	else System.out.println("입력 실패");//피드백 처리
        } catch (Exception e) {
			System.out.println("Exception" + e.toString());
		}
        return result;
	}
	/***********************************************************
	 * 세자리 입력한 숫자에 대한 힌트문 구현하기
	 * @param user 사용자가 입력한 값
	 * @return 힌트문 반환 예)1스 2볼
	 ***********************************************************/
	public String account(String user) {
		int temp = Integer.parseInt(user);
		my[0] = temp/100;//123/100=1
		my[1] = (temp%100)/10;//2
		my[2] = temp%10;//3
		for(int me:my) {
			System.out.println("me:"+me);//0 0 0
		}
		int strike = 0;
		int ball = 0;
		for(int i=0;i<com.length;i++) {
			for(int j=0;j<my.length;j++) {
				if(com[i]==my[j]) {//내가 입력한 숫자중에 컴터에 그 숫자가 있니?
					if(i==j) {//혹시 그 숫자가 자리도 일치하는거야?
						strike++;
					}//스트라이크 결정
					else {
						ball++;
					}
				}//////볼카운트 확보
			}//////////end of innert for
		}//////////////end of outter for
		if(strike==3) {
			return "정답입니다. 축하합니다.";
		}
		return strike+"스 "+ball+"볼";
	}		
	public void ranCom() {
		Random r = new Random();//0.0~
		com[0] = r.nextInt(10);//0.0~10.0
		do {
			com[1] = r.nextInt(10);//0.0~10.0
		}while(com[0]==com[1]);
		do {
			com[2] = r.nextInt(10);//0.0~10.0			
		}while((com[0]==com[2])||(com[1]==com[2]));
	}
}
