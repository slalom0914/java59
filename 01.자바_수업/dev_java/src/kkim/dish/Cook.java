package kkim.dish;

public class Cook implements Runnable {
	private Table table;
	Cook(Table table){
		this.table = table;
	}
	@Override
	public void run() {
		while(true) {
		//임의의 요리를 하나 선택해서 table에 추가한다.
			int idx = (int)(Math.random()*table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
