package oracle.jdbc2;

import java.util.Vector;

public class ZipCodeList {

	public static void main(String[] args) {
		//Vector<Object> v2 = new Vector<Object>();
		Vector v2 = new Vector();//제네릭을 생략한 경우
		v2.add("사과");
		v2.add("딸기");
		v2.add(1,"바나나");//끼워넣기
		Vector<String> v = new Vector<String>();
		v.add("사과");
		v.add("딸기");
		v.add(1,"바나나");//끼워넣기
		v2.remove(2);
		//v2.remove(2);
		for(int i=0;i<v.size();i++) {
			//String f = v2.get(i);//타입이 Object라서 담을 수가 없어요. 타입이 맞지 않죠
			String f = (String)v2.get(i);
			System.out.println("v : "+v.get(i));
		}
	}

}
