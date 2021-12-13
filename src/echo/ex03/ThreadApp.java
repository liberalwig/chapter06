//2021.12.13(월)11:55수업:06.NetworkThread중 02.Thread

package echo.ex03;

public class ThreadApp {

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new DigitThread();
		thread.start(); // run누르면 DigitThread가 그냥 실행됨

		for (char ch = 'A'; ch <= 'Z'; ch++) {// 디행히 알파벳은 코드숫자 하나 올라가면 바로 다음 알파벳임
			System.out.println(ch);
			Thread.sleep(1000);
		}

	}

}
