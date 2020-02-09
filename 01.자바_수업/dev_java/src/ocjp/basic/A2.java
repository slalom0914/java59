package ocjp.basic;

public class A2 {

	int methodA(int num[]) {
		int tot = 0;
		for(int i=0;i<num.length;i++) {
			tot = tot + num[i];
		}
		return tot;
	}
	public static void main(String[] args) {
		A2 a2  = new A2();
		int num[] = {1,2,3};
		a2.methodA(num);
	}

}
