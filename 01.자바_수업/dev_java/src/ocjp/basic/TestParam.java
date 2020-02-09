package ocjp.basic;
/*
 * TestParam.java소스안에 두 개 클래스를 가짐.
 * TestParam.java를 컴파일하면(고급언어->저급언어)
 * Param.class와 TestParam.class가 만들어짐.
 * Param클래스에는 전변 ival이 있고 초기값은 현재  0임.
 * 그값이 TestParam클래스의 main메소드에서 100으로 초기화됨.
 * effectParam안에서는 500으로 초기화가 되었다.
 * 이 때 main ival이 먼저 출력되는가? 아니면 sub ival이 먼저 출력되는가?
 * 둘 중에 먼저 출력된 값이 나중에 출력되는 곳에 영향을 미쳤다 아니면 영향을 주지 않았다. 판단.
 * 
 * 두번째 변화 주기
 * 21번 주석이 있을때와 없을 때 결과에 차이가 있다|없다.
 * 만약 차이가 있다고 생각한다면 어떤 차이가 어떻게 있는 것인지 옆사람에게 설명해 볼것.
 */
class Param{
	int ival = 0;
}
public class TestParam {
	void effectParam(Param p) {//원본을 받았으나
		p = new Param();//여기서 복제본 새로 생성됨
		p.ival = 500;//복제본이 500으로 변경
		System.out.println("sub ival===>"+p.ival);//500
	}
	/* 28(entry-point)-31(객체가 램에 상주하게됨:인스턴스화)-32(전변초기화-0)-33(100)
	 * 34(파라미터로 원본)-20(32번객체가리킴)-22(원본이 바뀜)[0-100-500]-23-24-35
	 */
	public static void main(String[] args) {
		//내안에 있는 메소드를 호출하지만 static영역에서 non-static을 호출할땐
		//반드시 인스턴스화
		TestParam tp = new TestParam();
		Param p = new Param();//지변이지만 원본 변수 p의 주.번
		p.ival = 100;
		tp.effectParam(p);//동일한 주.번
		System.out.println("main ival===>"+p.ival);//500,100
	}//end of main
}//////end of TestParam



