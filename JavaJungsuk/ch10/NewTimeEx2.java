package ch10;

import java.time.*;
import java.time.temporal.ChronoField;

public class NewTimeEx2 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		//LocalDate + LocalTime = LocalDateTime
		LocalDateTime dt = LocalDateTime.of(date, time);
		
		//LocalDateTime + 시간대(time-zone) = ZonedDateTime
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = dt.atZone(zid);
		String strZid = zdt.getZone().getId();
		
		//time-zone 변경
		ZonedDateTime seoulTime = ZonedDateTime.now();
		ZoneId nyid = ZoneId.of("America/New_York");
		ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyid);
		
		ZoneOffset krOffset = zdt.getOffset();
		int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);
				
		//ZonedDateTime -> OffsetDateTime
		OffsetDateTime odt = zdt.toOffsetDateTime();
		
		System.out.println("LocalDate : " + date);
		System.out.println("LocalTime : " + time);
		System.out.println("LocalDateTime : " + dt);
		System.out.println("ZonedDateTime : " + zdt);
		System.out.println("ZoneId : " + zid);
		System.out.println("Seoul   : " + seoulTime);
		System.out.println("NewYork : " + nyTime);
		System.out.println("ZoneOffset : " + krOffset);
		System.out.println("ZoneOffsetInSec : " + krOffsetInSec);
		System.out.println("OffsetDateTime : " + odt);
	}
}
