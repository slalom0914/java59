package thread.bank;

import java.util.StringTokenizer;

public class MessageTest {

	public static void main(String[] args) {
		String msg 
		= "200#apple#test#오늘 스터디 할까?";
		StringTokenizer st = null;
		if(msg!=null) {
			st = new StringTokenizer(msg,"#");
		}
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
	}

}

