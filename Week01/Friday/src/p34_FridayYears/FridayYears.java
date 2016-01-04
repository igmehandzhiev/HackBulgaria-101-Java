package p34_FridayYears;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class FridayYears {
	public static int fridayYears(String start, String end) {
		int startYear = Integer.parseInt(start);
		int endYear = Integer.parseInt(end);
		int count = 0;
		
		for(int i = startYear; i <= endYear; i++) {
			if(isAFridayYear(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean isLeapYear (int year) {
        if( (year % 400 == 0) || ( (year % 4 == 0) && (year % 100 != 0) ) ) {
        	return true;
        }
        return false;
	}
		
	
	public static boolean isAFridayYear(int year) {
		int counter = 0;
		
		for(int i = 0; i < 12; i++) {
			switch(i + 1) {
			case 1:
				for (int j = 1; j <= 31; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.JANUARY, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 3:
				for (int j = 1; j <= 31; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.MARCH, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 5:
				for (int j = 1; j <= 31; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.MAY, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 7:
				for (int j = 1; j <= 31; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.JULY, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 8:
				for (int j = 1; j <= 31; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.AUGUST, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 10:
				for (int j = 1; j <= 31; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.OCTOBER, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 12:
				for (int j = 1; j <= 31; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.DECEMBER, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 4:
				for (int j = 1; j <= 30; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.APRIL, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 6:
				for (int j = 1; j <= 30; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.JUNE, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 9:
				for (int j = 1; j <= 30; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.SEPTEMBER, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 11:
				for (int j = 1; j <= 30; j++) {
					Calendar cal = new GregorianCalendar(year, Calendar.NOVEMBER, j);
					if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
						counter++;
					}
				}
				break;
			case 2:
				if(isLeapYear(year)) {
					for (int j = 1; j <= 29; j++) {
						Calendar cal = new GregorianCalendar(year, Calendar.FEBRUARY, j);
						if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
							counter++;
						}
					}
				} else {
					for (int j = 1; j <= 28; j++) {
						Calendar cal = new GregorianCalendar(year, Calendar.FEBRUARY, j);
						if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
							counter++;
						}
					}
				}
				break;
			}
			
		}
		return counter == 53;
	}
}
