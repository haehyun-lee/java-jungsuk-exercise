package ch10;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

//자신이 태어난 날부터 지금까지 지난 날짜 구하기

public class Exercise10_6 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(2000, 1, 1);
		
		System.out.println("birth day=" + birthday);
		System.out.println("today=" + today);
		
		long dayDiff = birthday.until(today, ChronoUnit.DAYS);
		
		System.out.println(dayDiff + " days");
	}
}
