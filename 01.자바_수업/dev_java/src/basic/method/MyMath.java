package basic.method;
//메소드를 설계할 수 있다.
//리턴타입은 뭘로 하지? -나는 실수영역까지 처리할거야 - double - 1개
//파라미터는 몇 개로 할까? - 두 개중에서 - double, double - 2개
//파라미터의 타입은 어떡하지? - 실수영역까지
//메소드의 이름은 무엇으로 할까? max
public class MyMath {
	double max(double fn,double sn){
		double maxNumber = 0.0;
	//둘(fn과 sn)중에 누가 더 크니?	
		if(fn>sn) {
			//실행문
			maxNumber = fn;
		}
		else if(sn>fn){
			maxNumber = sn;
		}else {
			maxNumber=0;
		}
		return maxNumber;
	}//end of max
}
