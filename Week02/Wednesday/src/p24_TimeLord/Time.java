package p24_TimeLord;

import java.time.LocalDateTime;


public class Time {
	int seconds, minutes, hours, year, day, month;
	
	public Time(int hours, int minutes, int seconds, int day, int month, int year) {
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		String formatted = String.format("%02d:%02d:%02d %02d.%02d.%02d", hours, minutes, seconds, day, month, year);
		return formatted;
	}
	
	public static Time now() {
		
		LocalDateTime now = LocalDateTime.now();
		
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		Time atm = new Time(hour, minute, second, day, month, year);
		
		return atm;
		
	}
}

