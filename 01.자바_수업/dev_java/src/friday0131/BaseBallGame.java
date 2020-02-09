package friday0131;

import java.util.Random;
import java.util.Scanner;

public class BaseBallGame {
	int com[] = new int[3];
	int my[] = new int[3];//my[0]=0 my[1]=0 my[2]=0
	//세자리 숫자를 채번하는 메소드 입니다.
	//새게임 버튼을 누르거나 강제 종료 후 다시 시작할 때 호출됩니다.
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
	//insert here -  account메소드 구현 /////////////////////////
	/**************************************************************
	 * 사용자가 입력한 값에 대한 힌트를 출력하는 메소드 입니다.
	 * @param user 사용자가 입력한 세자리 숫자 입니다.
	 * @return 컴터가 채번한 숫자와 사용자가 입력한 숫자를 비교한 후 힌트문을 전달합니다.
	 * 버전
	 * 작성일
	 * 작성자 :  이순신
	 *************************************************************/
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
	/////////////////////////////////////////////////////////
	public static void main(String[] args) {
		BaseBallGame bbGame = new BaseBallGame();
		bbGame.ranCom();
		System.out.println(bbGame.com[0]
				       +""+bbGame.com[1]+""+bbGame.com[2]);
		System.out.println("게임이 시작되었습니다");
		System.out.println("세자리 숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		String user = null;
		//for문을 사용해 봅시다.
		int cnt = 0;
		for(int i=0;i<9;i++) {
			user = scan.nextLine();
			System.out.println("사용자가 입력한 값은 "+user+" 입니다.");
			System.out.println(++cnt+"회:"+user
					           +"===> "+ bbGame.account(user));
		}
	}

}







