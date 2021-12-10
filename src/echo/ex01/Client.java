//2021.12.10(금)11:59 수업: Chap06.네트워크쓰레드

package echo.ex01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket();

		System.out.println("<클라이언트 시작>");
		System.out.println("========================");

		System.out.println("[서버에 연결을 요청합니다.]");
		// 3.커넥트를 요청한다.
		socket.connect(new InetSocketAddress("192.168.0.7", 10001));

		System.out.println("[서버에 연결되었습니다.]");
		socket.close();

	}

}
