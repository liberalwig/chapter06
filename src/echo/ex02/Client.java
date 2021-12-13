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
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {

		Socket socket = new Socket();

		System.out.println("<클라이언트 시작>");
		System.out.println("========================");

		System.out.println("[서버에 연결을 요청합니다.]");
		// 3.커넥트를 요청한다.
		socket.connect(new InetSocketAddress("192.168.219.101", 10001));

		System.out.println("[서버에 연결되었습니다.]");

		// 서버로 메세지 보내기용 stream
		OutputStream os = socket.getOutputStream();// 주stream
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);

		// 서버에서 메세지 받기용 stream
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		// Scanner (키보드 입력용)
		Scanner sc = new Scanner(System.in);

		// 반복 구간
		while (true) { // str.equals("/q")라 해도 똑같은데 혹시 str 주소가 없을까봐 순서 변경해서 작성

			String str = sc.nextLine();

			if ("/q".equals(str)) {// ==는 바로 메모리에 못 넣고 주소 비교하는 거라 equals
				System.out.println("종료키 입력");
				break;
			}

			// 메세지 보내기
			bw.write(str);
			bw.newLine();
			bw.flush();

			// 메세지 받기
			String reMsg = br.readLine();
			System.out.println("server:[" + reMsg + "]");

			System.out.println("========================");
			System.out.println("<클라이언트 종료>");
			bw.close();
			sc.close();
			socket.close();

		}

	}
}