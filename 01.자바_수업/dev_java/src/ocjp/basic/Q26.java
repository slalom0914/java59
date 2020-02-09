package ocjp.basic;

public class Q26 {

	public static void main(String[] args) {
		int i = 1;//i=1
		int j = i++;//i=2, j=1
		if((i == ++j) && (i++ == j)) {//(2==2) or (2==2)
			//i += j;//무조건 실행됨
			i=i+j;
		}
		System.out.println("i = " + i);		
	}

}
