package models;

public class Timer extends Thread {
	private static Timer instance;
	
	private int second;
	
	private Timer() {
		second = 0;
	}
	
	public static Timer getInstance() {
		if (instance == null) {
			instance = new Timer();
		}
		return instance;
	}
	
	public void setTime(int second) {
		this.second = second;
	}
	
	public int getTime() {
		return second;
	}
	
	@Override
	public void run() {
		do {
			int minute = second / 60;
			//System.out.printf("%02d:%02d\n", minute, second % 60);
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			second--;
		} while (second >= 0);
	}
}
