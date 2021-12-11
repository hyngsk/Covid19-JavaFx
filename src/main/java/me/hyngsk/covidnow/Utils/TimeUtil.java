package me.hyngsk.covidnow.Utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TimeUtil implements Runnable {
	public TimeUtil() {
	}

	/**
	 * 4. static 메소드
	 */
	public static String getNow() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.now(ZoneId.of("Asia/Tokyo")).format(formatter);
	}

	public void run() {
		while (true) {
			String strDate = getNow();
//			System.out.println(strDate);
			try {
				Thread.sleep(999);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
