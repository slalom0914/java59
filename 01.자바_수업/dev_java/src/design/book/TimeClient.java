package design.book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient extends Thread {
	//서버에서 청취한 현재 시간 정보를 담을 변수
	String timeStr = null;
	public void run() {
		String time = null;
		Socket socket = null;
		ObjectInputStream ois = null;//읽기-듣기
		ObjectOutputStream oos = null;//쓰기-말하기
		try {
			socket = new Socket("192.168.0.244",3000);
			oos = new ObjectOutputStream(socket.getOutputStream());
			//클라이언트가 말한 내용을 듣기
			ois = new ObjectInputStream(socket.getInputStream());
			while(true) {
				time = (String)ois.readObject();
				System.out.println(timeStr);
				try {
					sleep(1000);
				} catch (InterruptedException ie) {
						System.out.println("앗 ~~ ...");
				}
			}
		} catch (Exception ie) {
			System.out.println("타임 서버에 접속할 수 없습니다.");
		}
	}
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();
	}

}
