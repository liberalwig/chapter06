//2021.12.13(월)11:55수업:06.NetworkThread중 02.Thread

package echo.ex03;

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
