package method.zipcode;

public class Test {
	//메소드를 통해서 인스턴스화 하는 이유는 뭘까?
	//메소드를 사용해서 객체 주입을 받는 경우 무엇을 더 할 수 있나?
	static Test t2 = null;
	public static Test getInstance() {//미묘한 차이가 있기 때문에....
		if(t2==null) {
			t2 = new Test();
		}
		return t2;
	}
	String setName() {
		return "이순신";
	}
	public static void main(String[] args) {
		Test t = getInstance();
		System.out.println(t);
		Test t1 = new Test();
		System.out.println(t1);
		//insert here 이순신 출력해보자
		//이럴 경우 기존에 있는 객체를 사용하여 메소드가 호출됨
		//즉 불필요한 객체를 또 정의하지 않았음.
		System.out.println(t.setName());
		//이렇게 할 경우 새로운 객체가 또 만들어지고 메소드가 호출됨.
		//주소번지가 없으므로 다른 메소드를 호출할 때나 변수를 접근할 수 없음.
		System.out.println(new Test().setName());
		//메소드를 통해서 객체를 생성하므로 null인 경우만 새로 생성하고 
		//기존에 유지되고 있다면 새로 생성하지 않음.
		System.out.println(Test.getInstance().setName());
	}

}









