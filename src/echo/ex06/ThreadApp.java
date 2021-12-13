//2021.12.13(월)14:57 수업:: Runnable Interface 연습문제 

package echo.ex06;

public class ThreadApp {

	public static void main(String[] args) {

		Runnable digit = new DigitImpl();
		Runnable lower = new LowerImpl();
		Runnable upper = new UpperImpl();

		Thread thread1 = new Thread(new DigitImpl());// 생성자는 public Thread();와 public Thread Runnable( ;이렇게 2개가 있으므로Runnable택
		Thread thread2 = new Thread(lower);
		Thread thread3 = new Thread(upper);

		thread1.start();
		thread2.start();
		thread3.start();

	}

}
