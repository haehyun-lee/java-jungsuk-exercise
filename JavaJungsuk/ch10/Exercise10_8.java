package ch10;

import java.time.*;
import java.time.temporal.*;

//서울과 뉴욕간의 시차
public class Exercise10_8 {

	public static void main(String[] args) {
		//ZonedDateTime <- ZoneId
		ZonedDateTime seoulTime = ZonedDateTime.now();
		ZoneId nyId = ZoneId.of("America/New_York");
		ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
		
		//ZonedDateTime -> ZoneOffset
		ZoneOffset krOffset = seoulTime.getOffset();
		int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);
		ZoneOffset nyOffset = nyTime.getOffset();
		int nyOffsetInSec = nyOffset.get(ChronoField.OFFSET_SECONDS);
		
		int diffOffset = (krOffsetInSec - nyOffsetInSec) / (60 * 60);

		System.out.println(seoulTime);
		System.out.println(nyTime);
		System.out.println("sec1=" + krOffsetInSec);
		System.out.println("sec2=" + nyOffsetInSec);
		System.out.println("diff=" + diffOffset + " hrs");
	}
}