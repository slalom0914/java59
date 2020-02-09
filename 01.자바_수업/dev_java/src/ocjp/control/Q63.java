package ocjp.control;

public class Q63 {

		public static void main(String[] args) {
			int i;
			for (i=0;i<= 10;i++){
				int j = 10;
				if( i>6) break;//i가 7이면
			}
			//요기로 탈출
			System.out.println(i);  //오류
			int j = 5;
			System.out.println(j);  //오류
		}

}
