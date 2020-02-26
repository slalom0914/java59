package design.book;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer extends Thread {
	public void run() {//지연처리가능, 들은 정보를 내보낼 수 있다., 1초에 한번씩 시간정보를 내보낸다.
		try {
			//PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			sleep(3000);//3초 동안 지연시키기
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("run call....");
	}
	public static void main(String[] args) {
		int port= 3000;
		//서버소켓은 사용자가 접속해 오기를 기다립니다. 언제까지 기다려야 할지 알 수 없죠..
		ServerSocket server = null;
		//손님이 접속해 오면 그 손님의 소켓 정보를 저장합니다.
		Socket client = null;
		try {
			server = new ServerSocket(port);
		} catch (Exception e) {
			// TODO: handle exception
		}//////////////end of try
		System.out.println("TimeServer started successfully...");
		while(true) {
			try {
		//클라이언트측에서 접속해온 정보를 client소켓에게 넘김.		
				client = server.accept();//대기
				System.out.println("New Client connected...."+client.toString()+"\n");
				TimeServer ts = new TimeServer();
				ts.start();//스레드의 run메소드를 호출하는 메소드
			} catch (Exception e) {
				// TODO: handle exception
			}
		}		
	}

}


