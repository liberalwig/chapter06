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

		// 5. 서버로 메세지 보내기용 stream
		OutputStream os = socket.getOutputStream(); // 1단인 총에 해당하는 FileOutputStream은 반드시 있어야 함. 주Stream에 해당함.
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8"); // 2단은 번역기같은 거라서 도착어를 무엇으로 할 지를 정해줘야 하므로 UTF-8을
																		// 기입.기능이 떨어질 순 있겠으나 2단,3단은 없어도 무방
		BufferedWriter bw = new BufferedWriter(osw); // 괄호에 넣은 것과 순서를 자세히 살펴보면 단수를 알 수 있다, 괄호 안 주의

		// 메세지 보내기
		String str = "안녕하세요"; // String에 쓴다(Write)는 건 파일에 저장한다기보다는 내 바깥으로 <내보내는> 개념.
		bw.write(str);// Scanner가 오든 그림파일이 오든 주stream이 알아서 할 것이다. 이 경우엔 '안녕하세요'가 보내짐
		bw.newLine();
		bw.flush();// 받은 메세지에 'null이 나와서 강사님이 이거 입력하시니 "안녕하세요"가 나옴
					// 운반시키는 쟁반이 다 차야 움직여줌. 꽉 차야 움직일 예정인데 안 찼어서 기다린 건데 flush면 그냥 보내기로 치는 셈임.

		// 8. 서버에서 메세지 받기용 stream
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");// 내가 아까 UTF-8안 넣으니까 CMD에 꿇서ㅣㅏㅈㄷ거싮 이렇게 뜸.
		BufferedReader br = new BufferedReader(isr);

		// 메시지 받기
		String reMsg = br.readLine();
		System.out.println("server: [" + reMsg + "]");

		socket.close();

	}

}

/*
 * 이클립스로 클라이언트와 서버 둘 다 켜면 접속 한 번 되고 그 뒤로 이 프로그램은 끝난다. 끝난 뒤이기 때문에 이 이후에 CMD로
 * 클라이언트를 열어도 아무 소용이 없게 된다. 즉, 한 번 연결하고 나면 꺼진다는 말. 나와 황희원 씨가 이클립스로 둘을 열고나서
 * debug떴던 이유
 */