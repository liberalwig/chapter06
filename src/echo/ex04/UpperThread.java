//2021.12.13(월)13:41 수업

package echo.ex04;

public class UpperThread extends Thread {

	@Override
	public void run() {

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch);

			try {// 너무 빨리 돼서 지연시키기 위해 해보는 작업
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
