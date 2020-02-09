package friday0207;

import java.util.Random;

public class BaseBallGameLogic {
	int com[] = new int[3];
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
