package basic.method;
import java.util.Scanner;
public class WeightAccountVer2 {
	double d_ew = 0.0;//지구의 몸무게 담을 변수-  전역변수 사용 연습해봐요
	double d_mw = 0.0;//달의 몸무게 담을 변수
	/*************************************************************
	 * 
	 * @param d_ew - 지구의 몸무게
	 * @return - 달의 몸무게
	 ************************************************************/
	public double moon_weight(double d_ew) {
		d_mw=(d_ew*17)/100.0;
		return d_mw;
	}
	public static void main(String[] args) {
		WeightAccountVer2 wa2 = new WeightAccountVer2();
		System.out.println("당신의 몸무게를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		wa2.d_ew = scan.nextDouble();
		wa2.d_mw = wa2.moon_weight(wa2.d_ew);
		System.out.println("달의 몸무게 : "+wa2.d_mw);
	}
}
/*
 * 두 개의 정수 중에서 큰 숫자를 반환하는 max함수를 구현하세요.
 * 두 개의 정수를 입력 받고 큰 숫자를 출력합니다.
 * 출력) 정수(두 개): 5 8
 *      최대값 : 8
 * 
 */




