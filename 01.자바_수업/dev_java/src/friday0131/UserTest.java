package friday0131;

import java.util.Scanner;

public class UserTest {
	int com[] = new int[3];
	int my[] = new int[3];
	//사용자가 입력한 값을 받아오는 곳
	/**************************************************************
	 * 사용자가 입력한 값에 대한 힌트를 출력하는 메소드 입니다.
	 * @param user 사용자가 입력한 세자리 숫자 입니다.
	 * @return 컴터가 채번한 숫자와 사용자가 입력한 숫자를 비교한 후 힌트문을 전달합니다.
	 * 버전
	 * 작성일
	 * 작성자 :  이순신
	 *************************************************************/
	public String account(String user) {
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
		return strike+"스 "+ball+"볼";
	}
	public static void main(String[] args) {
		System.out.println("세 자리 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int imsi = 0;//채번한 숫자를 담을 변수
		int cnt = 0;//입력 받은 횟수를 세는 변수
		while(cnt<3) {
			imsi = scan.nextInt();
			System.out.println(cnt+": 사용자가 입력한 숫자는 "+imsi+" 입니다.");
			cnt++;
		}
	}

}
