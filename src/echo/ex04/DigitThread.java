//2021.12.13(월)13:41 수업

package echo.ex04;

public class DigitThread extends Thread {

	@Override
	public void run() {

		for (int cnt = 0; cnt <= 10; cnt++) {
			System.out.println(cnt);

			try {// 너무 빨리 돼서 지연시키기 위해 해보는 작업
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
