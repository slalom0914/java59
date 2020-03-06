package thread.bank;

import java.util.StringTokenizer;

public class MessageTest2 {

	public static void main(String[] args) {
		String msg 
		= "200#apple#test#오늘 스터디 할까?";
		msg = "210#apple#오늘 수업 끝나고 농구할까?";
		msg = "100#apple";//입장하기
		StringTokenizer st = null;
		if(msg!=null) {
			st = new StringTokenizer(msg,"#");
		}
		int protocol = 0;
		//protocol = Integer.parseInt(st.nextElement().toString());
		protocol = Integer.parseInt(st.nextToken());
		switch(protocol) {
			case 100:
				System.out.println("100일 때 해야 할 일");
				break;
			case 200:
				System.out.println("200일 때 해야 할 일");
				break;
			case 210:
				System.out.println("210일 때 해야 할 일");
				break;
		}
	}

}

