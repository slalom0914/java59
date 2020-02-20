package test.d20200219;

import java.util.Calendar;

public class Test1 {

	public static void main(String[] args) {
		int year = 0;
		year = 1996;
		int age = 0;
		int cyear= 0;
		Calendar cal = Calendar.getInstance();
		cyear=cal.get(Calendar.YEAR);
		age = cyear-1996;
		System.out.println("age==>"+age);
		System.out.println("year==>"+year);
	}

}
