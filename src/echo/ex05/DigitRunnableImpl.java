//2021.12.13(월)14:11 수업: Runnable Interface

package echo.ex05;

public class DigitRunnableImpl implements Runnable {

	@Override
	public void run() {

		for (int cnt = 0; cnt <= 10; cnt++) {
			System.out.println(cnt);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}

//thread기능을 써야 하는데 이미 부모클래스를 가진 경우가 있어서 interface를 사용