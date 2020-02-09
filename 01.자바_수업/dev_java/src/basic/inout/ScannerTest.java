package basic.inout;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input =null;
		while(true) {
			input = scan.nextLine();
			System.out.println("입력된 문자열 : "+input);
			if(input.equals("q")) {
				break;
			}
		}
		System.out.println("종료");
	}
}
