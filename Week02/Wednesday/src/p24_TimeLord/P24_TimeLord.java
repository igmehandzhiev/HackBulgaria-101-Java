package p24_TimeLord;

import java.util.Scanner;

public class P24_TimeLord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input time.");
		System.out.print("Hours:");
		int hours = sc.nextInt();
		System.out.print("Minutes:");
		int minutes = sc.nextInt();
		System.out.print("Seconds:");
		int seconds = sc.nextInt();
		
		System.out.print("Day:");
		int day = sc.nextInt();
		System.out.print("Month:");
		int month = sc.nextInt();
		System.out.print("Year:");
		int year = sc.nextInt();
		
		Time t1 = new Time(hours, minutes, seconds, day, month, year);
		System.out.println(t1.toString());
		System.out.print("Time now: ");
		System.out.println(Time.now().toString());
		sc.close();
	}

}
