package design.book;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TimeServerThread extends Thread {
	TimeServer ts = null;
	ObjectInputStream ois = null;//읽기-듣기
	ObjectOutputStream oos = null;//쓰기-말하기
	String time = "10:20:35";
	public TimeServerThread(TimeServer ts) {
		this.ts = ts;
		try {
			oos = new ObjectOutputStream(ts.socket.getOutputStream());
			//클라이언트가 말한 내용을 듣기
			ois = new ObjectInputStream(ts.socket.getInputStream());
			//TimeServer에서 정의한 setTimer메소드에서 현재 장치에 시간정보 가져오기
			time = ts.setTimer();
			//oos.writeObject(time);
			//내가 입장하기 전에 있던 친구들에게 전송하기
			for(TimeServerThread tst:ts.globalList) {
				this.send(time);
			}
			ts.globalList.add(this);
			this.broadCasting(time);
		} catch (Exception e) {
			System.out.println("TimeServerThread:"+e.toString());
		}		
	}
	//현재 서버에 접속한 모든 사용자에게 시간 정보 방송하기 구현
	public void broadCasting(String msg) {
		//현재 서버에 몇사람이 있는지 출력하기
		ts.jta_log.append("현재 인원수:"+ts.globalList.size()+"\n");
		synchronized(this) {//다른 스레드가 인터셉트 하는 것을 방어하기 위해 동기화처리함
			for(TimeServerThread tst:ts.globalList) {
				tst.send(msg);
			}
		}
	}//////////////end of boardCasting
	
	//서버에서 클라이언트에게 전송하는 메세지 구현
	public void send(String msg) {
		try {
			oos.writeObject(msg);
		} catch (Exception e) {
			e.printStackTrace();//예외 발생시 에러메시지 history출력
		}
	}////////////////end of send
	public void run() {
		while(true) {
			try {
				//TimeServer에서 정의한 setTimer메소드에서 현재 장치에 시간정보 가져오기
				time = ts.setTimer();				
				oos.writeObject(time);
				sleep(1000);//1초 동안 지연시키기		
			} catch (IOException ie) {
				System.out.println(ie.toString());				
			} catch (InterruptedException ie) {
				System.out.println("다른 스레드가 새치기를 했을 때");
			} 
		}////////////end of while		
	}////////////////end of run
}
