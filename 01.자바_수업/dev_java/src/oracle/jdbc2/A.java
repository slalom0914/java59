package oracle.jdbc2;

public class A {
	void methodA(ZipCodeVO zcVOS[]) {
		ZipCodeVO zVO = new ZipCodeVO();
		zcVOS[0] = zVO;
		zVO = null;//여기서 다시 null상태로 초기화가 된다.
		zVO = new ZipCodeVO();//다른 클래스가 정의되므로 그 전에 저장해둔다.
		zcVOS[1] = zVO;
		//자바에서는 같은 타입의 변수를 중복정의 불가함.
		//타입을 제거한 후 이어야 같은 변수로 같은 타입의 다른 객체를 생성할 수 있다.
		zVO = null;
		zVO = new ZipCodeVO();
		zcVOS[2] = zVO;
	}
	public static void main(String[] args) {
		A a = new A();
		ZipCodeVO zcVOS[] = new ZipCodeVO[3];
		//메소드 호출시 파라미터로 주소번지를 넘겨서 다른 메소드에서 재정의할 수 있다.
		//그 작업을 methodA에서 처리해보자.
		a.methodA(zcVOS);
		for(int i=0;i<zcVOS.length;i++) {
			System.out.println("zcVOS["+i+"]="+zcVOS[i]);			
		}
	}
}
