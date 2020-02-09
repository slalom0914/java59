package basic.method;

public class WeightAccount {

	public static void main(String[] args) {
		System.out.println("당신의 몸무게를 입력하세요.");
		java.util.Scanner scan = new java.util.Scanner(System.in);
		double d_ew=0;//지구의 몸무게
		d_ew = scan.nextDouble();
		System.out.println("당신이 입력한 값은 "+d_ew);
		//달의 몸무게를 담기
		double d_mw=0;//달의 몸무게
		//17% 
		//d_mw=(d_ew*17)/(double)100;
		d_mw=(d_ew*17)/100.0;
		System.out.println("달의 몸무게 : "+d_mw);
	}

}
