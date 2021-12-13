//2021.12.13(월)13:41 수업

package echo.ex04;

public class ThreadApp {
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new DigitThread();
		Thread thread2 = new LowerThread();
		Thread thread3 = new UpperThread();

		thread1.start();// start대신 run하지 말 것 강조당부
		thread2.start();
		thread3.start();

	}
}
