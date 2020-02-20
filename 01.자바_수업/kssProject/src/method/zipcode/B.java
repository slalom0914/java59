package method.zipcode;

public class B {
	public static void main(String args[]) {
		int i = 0;
		int j  = 0;
		//i = 100/0;		
		
		try {
			//만약 예외가 발생하지 않으면 없는 것과 동일한 실행
			i = 100/j;	//예외가 발생할 가능성이 있는 코드를 작성함.		
		} catch (Exception e) {
			System.out.println("0으로 나눈값은 계산할 수 없잖아.");
		}
		
		System.out.println("변수 i는 "+i);
	}
}
