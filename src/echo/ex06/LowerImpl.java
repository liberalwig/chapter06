//2021.12.13(월)14:57 수업: : Runnable Interface 연습문제

package echo.ex06;

public class LowerImpl implements Runnable {

	@Override
	public void run() {

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
