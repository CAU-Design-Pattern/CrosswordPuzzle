package models;

import java.util.Observable;

public class GameTimer extends Observable implements Runnable {
	private static GameTimer instance;
	
	private int seconds;
	
	private GameTimer() {
		seconds = 0;
	}
	
	public static GameTimer getInstance() {
		if (instance == null) {
			instance = new GameTimer();
		}
		return instance;
	}
	
	public void setTime(int seconds) {
		this.seconds = seconds;
	}
	
	public int getTime() {
		return seconds;
	}
	
	public String getTimeStamp() {
		int minute = seconds / 60;
		int second = seconds % 60;
		
		StringBuilder sb = new StringBuilder();
		if (minute < 10) {
			sb.append("0");
		}
		sb.append(String.valueOf(minute));
		sb.append(":");
		if (second < 10) {
			sb.append("0");
		}
		sb.append(String.valueOf(second));
		
		return sb.toString();
	}
	
	@Override
	public void run() {
		do {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				break;
			}
			seconds--;
			setChanged();
			notifyObservers();
		} while (seconds > 0);
	}
}
