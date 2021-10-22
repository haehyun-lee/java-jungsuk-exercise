package ch10;

import java.util.*;
import java.text.*;

public class Exercise10_5 {
	/**
	 * yyyymmdd형식의 두 날짜간의 차이를 일(day) 단위로 반환
	 * @param yyyymmdd1	시작 날짜
	 * @param yyyymmdd2 끝 날짜
	 * @return	두 날짜의 차이
	 */
	static int getDayDiff(String yyyymmdd1, String yyyymmdd2) {
		int dayDiff = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		try {
			Date fromDate = sdf.parse(yyyymmdd1);
			Date toDate = sdf.parse(yyyymmdd2);
			
			Calendar fromCal = Calendar.getInstance();
			fromCal.setTime(fromDate);
			Calendar toCal = Calendar.getInstance();
			toCal.setTime(toDate);
			
			dayDiff = (int)((fromCal.getTimeInMillis() - toCal.getTimeInMillis()) / (1000 * 60 * 60 * 24));
			
		}catch(Exception e) {
			return 0;
		}
		
		return dayDiff;
	}
	
	public static void main(String[] args) {
		System.out.println(getDayDiff("20010103", "20010101"));
		System.out.println(getDayDiff("20010103", "20010103"));
		System.out.println(getDayDiff("20010103", "200103"));
	}
}
