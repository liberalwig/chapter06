//2021.12.13(월)10:49수업: 반복적으로 write-read 작동시키기

package echo.ex02;

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
		// 서버소켓을 메모리에 올리고 포트를 만들어준다
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.219.101", 10001));

		System.out.println("<서버 시작>");
		System.out.println("========================");
		System.out.println("[연결을 기다리고 있습니다.]");

		// 넥트가 오면 accept
		Socket socket = serverSocket.accept();// 통신을 위해 전화기 반쪽(새 소켓)을 만드는 꼴

		System.out.println("[클라이언트가 연결되었습니다.]");

		// 클라이언트에서 메세지 받기용 stream
		InputStream is = socket.getInputStream();// 이미 socket있기 때문에 new 불필요
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// 클라이언트로 메세지 보내기용 stream
		OutputStream os = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		while (true) {
			// 메세지 받기
			String msg = br.readLine();

			if (msg == null) {// 저쪽에서 주소가 안 온 경우
				System.out.println("[클라이언트 종료키 입력]");
				break;
			}
			System.out.println("받은메세지: " + msg);

			// 메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}

		System.out.println("========================");
		System.out.println("<서버 종료>");
		socket.close();
		serverSocket.close();

	}

}
