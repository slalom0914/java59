package athread.talk1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import thread.bank.Protocol;

public class TalkServerThread extends Thread {
	public TalkServer ts = null;
	Socket client = null;
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	public TalkServerThread(TalkServer ts) {
		this.ts = ts;
		this.client = ts.socket;
		try {
			oos = new ObjectOutputStream(client.getOutputStream());
			ois = new ObjectInputStream(client.getInputStream());
			//JTextArea에 현재 입장한 클라이언트 스레드 이름 출력하기
			ts.jta_log.append("this.getName():"+this.getName()+"\n");
			//나 전에 입장한 사람이 한 명도 없을 때는 아래 for문 실행기회 없음.
			//내가 입장하기 전에 입장한 클라이언트 스레드 이름 출력하기
			for(TalkServerThread tst:ts.globalList) {
				ts.jta_log.append("tst.getName():"+tst.getName()+"\n");
			}
			//현재 서버에 입장한 클라이언트 스레드 추가하기
			ts.globalList.add(this);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public void run() {
		boolean isStop = false;
		//while(true) {//무한루프에 빠질 수 있다.
		while(!isStop) {
			int protocol = 0;
			switch(protocol) {
				case Protocol.LOGIN:{
					
				}break;
				case Protocol.EXIT:{
					
				}break;
			}/////////////end of switch
		}/////////////////end of while
	}
}
