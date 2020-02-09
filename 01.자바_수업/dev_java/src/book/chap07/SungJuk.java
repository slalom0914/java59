package book.chap07;
/*
 * 1차배열, 2차배열 - 초기화하기, 꺼내서 사용하기
 * 배열에 담긴 정보를 꺼낼 수 있다.(반복문과 조건문 활용)
 * 개선된 for문 연습 - 컬렉션 프레임워크
 * 객체배열 따로 정리하기
 * 
 * 성적처리 방법
 * jumsus[i][j]
 * 변수 i는 row수 -  사람 구분
 * 변수 j는 column수 - 과목 구분
 * 총점 구하기
 * for문 한개로 가능하다|아니다.
 * 만일 아니다 2개일 것이다.
 * 만일 강호동의 총점을 구한다면 i가 고정된 상태에서 j가 변해야 한다.|아니다.
 * 
 * 메소드를 사용할 것인가?
 * 1단계 - main메소드안에만 코딩한다.
 * 2단계 - 메소드로 꺼내어 보기 : 재사용성과 이식성 높이는 코드를 작성하기
 * 
 * 총점과 평균 구하기에 배열을 사용할 것인가?
 * 총점
 * int korTotal = 0;
 * int engTotal = 0;
 * int mathTotal = 0;
 * 
 * 평균은 계산한 결과를 바로 출력하기
 * 
 */
public class SungJuk {
	int jumsus[][] = {
			{100,80,90} //1row - 강호동
		   ,{60,70,90}  //2row - 유재석
		   ,{80,70,70}
		   ,{90,90,90}
		   ,{80,80,80}
	};
	String names[] = {"강호동","유재석","강감찬","김유신","이성계"};
	String subjects[] = {"국어","영어","수학"};
	public static void main(String[] args) {
		SungJuk sj = new SungJuk();
		System.out.println("  no   kor    eng    math    total    avg  ");
		System.out.println("============================================");
		int i=0;
		int j=0;
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		for(i=0;i<sj.jumsus.length;i++) {
			int sum=0;
			korTotal = korTotal+sj.jumsus[i][0];//국어점수의합
			engTotal = engTotal+sj.jumsus[i][1];//영어점수의 합
			mathTotal = mathTotal+sj.jumsus[i][2];//수학점수의 합
			System.out.print(" "+(i+1)+" ");
			for(j=0;j<sj.jumsus[i].length;j++) {
				sum = sum+sj.jumsus[i][j];
				System.out.print("   "+sj.jumsus[i][j]+"  ");				
			}///end of inner 과목 수가 끝나는 위치
			System.out.println("     "+sum+"  "+sum/(double)sj.jumsus[i].length+"  ");
		}///////end of outter
		System.out.println("============================================");
		System.out.println(" 총점   "+korTotal+"  "+engTotal+"   "+mathTotal);
	}

}





