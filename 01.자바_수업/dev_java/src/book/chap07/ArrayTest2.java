package book.chap07;
/*
 * 문법에러- 규칙
 * 런타임에러- 실행오류(논리오류)
 * 
 */
public class ArrayTest2 {

	public static void main(String[] args) {
		int is[][] = new int[3][2];
		for(int i=0;i<is.length;i++) {
			for(int j=0;j<is[1].length;j++) {
				System.out.println("is["+i+"]["+j+"]="+is[i][j]);
			}
		}
	}

}
