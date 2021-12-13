//2021.12.13(월)14:57 수업: Runnable Interface 연습문제

package echo.ex06;

public class DigitImpl implements Runnable { // Run이 없을 때 runnable을 implements하면 오류남

	@Override
	public void run() {

		for (int cnt = 0; cnt <= 10; cnt++) {
			System.out.println(cnt);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
