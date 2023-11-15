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
	
	public String getTimeStamp() {
		return "%02d:%02d".formatted(second / 60, second % 60);
	}
	
	@Override
	public void run() {
		do {
			//System.out.printf("%02d:%02d\n", second / 60, second % 60);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			second--;
		} while (second >= 0);
	}
}
