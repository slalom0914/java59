package design.book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient extends Thread {
	public void run() {
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			socket = new Socket("192.168.0.244",3000);
			out = new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();
	}

}
