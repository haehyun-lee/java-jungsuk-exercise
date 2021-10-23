package ch10;

import java.time.*;										//LocalDate
import static java.time.DayOfWeek.*;					//TUESDAY
import static java.time.temporal.TemporalAdjusters.*;	//dayOfWeekInMonth

//2016년 12월 넷째주 화요일의 날짜 - TemporalAdjusters
public class Exercise10_7_new {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016, 12, 1);
		System.out.println(date.with(dayOfWeekInMonth(4, TUESDAY)));
	}
}