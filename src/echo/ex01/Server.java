//2021.12.10(금)11:59-16:15 수업: Chap06.네트워크쓰레드

package echo.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// 1.서버소켓을 메모리에 올린다
		ServerSocket serverSocket = new ServerSocket();

		// 2.포트를 만들어준다.
		serverSocket.bind(new InetSocketAddress("192.168.0.7", 10001));

		System.out.println("<서버 시작>");
		System.out.println("========================");
		System.out.println("[연결을 기다리고 있습니다.]");

		// 4. 커넥트가 오면 accept
		Socket socket = serverSocket.accept();// 통신을 위해 전화기 반쪽(새 소켓)을 만드는 꼴

		System.out.println("[클라이언트가 연결되었습니다.]");

		// 6. 클라이언트에서 메세지 받기용 stream
		InputStream is = socket.getInputStream();// 이미 socket있기 때문에 new 불필요
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 메세지 받기
		String msg = br.readLine();//
		System.out.println("받은 메세지: " + msg);

		// 7.클라이언트로 메세지 보내기용 stream
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 메세지 보내기
		bw.write(msg);
		bw.newLine();
		bw.flush();

		socket.close();
		serverSocket.close();

	}

}
