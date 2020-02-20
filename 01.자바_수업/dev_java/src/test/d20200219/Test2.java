package test.d20200219;

public class Test2 {

	public static void main(String[] args) {
		int dap1=0, dap2 = 0;
		int i=0;
		for(i=1;i<=1000;i++) {
			if(i%2==0 && i%5==0) {
				//제외
				continue;
			}else if(i%2==0 || i%5==0) {
				dap1=dap1+i;
			}
		}//////////end of for
		//i=1;////////////////
		while(i<=1000) {
			if(i%2==0 && i%5==0) {
				//제외
				continue;
			}else if(i%2==0 || i%5==0) {
				dap2=dap2+i;
			}
			System.out.println(i);
			//i++;//////////////무한루프 방지코드
		}////////////end of while
		System.out.println(dap1);
		System.out.println(dap2);
	}////////////////end of main
}
