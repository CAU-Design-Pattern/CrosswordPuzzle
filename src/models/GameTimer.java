package models;

import java.util.Observable;

public class GameTimer extends Observable implements Runnable {
	private static GameTimer instance;
	
	private int second;
	
	private GameTimer() {
		second = 0;
	}
	
	public static GameTimer getInstance() {
		if (instance == null) {
			instance = new GameTimer();
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
			setChanged();
			notifyObservers();
		} while (second > 0);
	}
}
