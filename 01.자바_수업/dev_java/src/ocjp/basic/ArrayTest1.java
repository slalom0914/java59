package ocjp.basic;

public class ArrayTest1 {
	static void methodA(int is[]) {//메소드 선언하기
		System.out.println("is : "+is);//hot spot- I@15db9742
		//파라미터로 넘어온 is배열의 원본에 세번째 방에 있는 값을 0에서 10으로 오버라이트
		is[2] =  10;
	}
	public static void main(String[] args) {
		//배열 선언과 생성하기-방이 세개 만들어짐.
		//변수 is는 배열타입이고 배열의 변수명이다.
		int is[] = new int[3];//is[0]=0, is[1]=0, is[2]=0, is[3]
		//배열의 주소번지 출력해 보기 I@15db9742
		System.out.println("main is : "+is);//hot spot
		//methodA(is)호출할 때 is배열의 주소번지를 메소드의 파라미터로 넘겨줌.
		//is의 주소번지는  I@15db9742
		methodA(is);//이 메소드 에서 is[2]방에 0값 대신 10으로 재정의함.
		//for(초기화;조건식;증감연산자 y=y-1 or i++, i--, ++i)
		//for(int x=0;x<3;x=x+1) {
		for(int x=0;x<3;x++) {
			System.out.println("is["+x+"]="+is[x]);
		}
		System.out.println("========================================");
		//개선된 for문 - 배열에 있는 모든 정보를 다 출력할때
		for(int a:is) {
			System.out.println(a);
		}
	}

}
