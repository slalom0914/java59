package book.chap02;

public class SungJuk2 {
	int hap(int kor, int eng) {
		int tot = 0;
		tot = kor+eng;//140
		return tot;
	}////////////end hap
	double avg(int tot,int subject) {
		return (double)tot/subject;
	}//end of avg
	public static void main(String[] args) {
		SungJuk2 sj = new SungJuk2();
		int kor=80;
		int eng=65;
		int tot = sj.hap(kor, eng);
		int subject=0;//여기는 과목 수를 담을 거야
		subject=2;//초기화 할 수 있는 사람.
		//국어 영어 두 과목이 니까 얼마로 초기화 해야하지?
		double avgValue = sj.avg(tot, subject);
		System.out.println("두 과목 평균은 "+avgValue);
	}
}



