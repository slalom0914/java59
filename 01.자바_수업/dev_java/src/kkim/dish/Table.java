package kkim.dish;

import java.util.ArrayList;

public class Table {
	String dishNames[] = {"donut","donut","burger"};
	//테이블에 놓을 수 있는 최대 음식수
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	public void add(String dish) {
		//테이블에 음식이 가득찼으면 테이블에 음식을 추가하지 않는다.
		if(dishes.size() >= MAX_FOOD) {
			return;
		}
		dishes.add(dish);
		System.out.println("Dishes:"+dishes.toString());
	}
	public boolean remove(String dishName) {
		for(int i=0;i<dishes.size();i++) {
			if(dishName.equals(dishes.get(i))) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}
	public int dishNum() {
		return dishNames.length;
	}
}
