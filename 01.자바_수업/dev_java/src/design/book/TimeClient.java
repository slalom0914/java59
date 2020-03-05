package design.book;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TimeClient extends Thread {
	JFrame jf = new JFrame();
	JLabel jlb_time = null;
	JLabel jlb_time2 = new JLabel("현재시간",JLabel.CENTER);
	//run메소드 보다 TimeClient생성자가 반드시 먼저 실행되어야 한다.
	public TimeClient(){
		jf.add("North",jlb_time2);
		jf.setSize(500, 400);
		jf.setVisible(true);		
	}
	/*
	 * 객체 주입관계는 BookApp.java에서 TimeClient(JLabel)생성자를 호출함.
	 */
	public TimeClient(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}
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
				//System.out.println(time);
				Font f = new Font("sans serif",Font.BOLD,30);
			    jlb_time.setFont(f);
				jlb_time.setText(time);
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
