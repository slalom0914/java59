package friday0131;

import java.util.Random;

public class RandomTest {
	int com[] = new int[3];
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
	public static void main(String[] args) {
		RandomTest rt = new RandomTest();
		for(int i=0;i<10;i++) {
			rt.ranCom();
			System.out.println(rt.com[0]+""+rt.com[1]+""+rt.com[2]);
		}
		/*
		int i = 3;
		while(i<3) {
			System.out.println("한번두 기회를....");
		}
		do {
			System.out.println("무조건 한번은 실행");
		}while(i<3);
		*/
	}

}
