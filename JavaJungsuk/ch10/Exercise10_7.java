package ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//2016년 12월 넷째주 화요일의 날짜 - Calendar, SimpleDateFormat
public class Exercise10_7 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);					//연
		cal.set(Calendar.MONTH, 11);					//월(0~11, 0:1월)
		cal.set(Calendar.DAY_OF_WEEK, 3);				//요일 (1~7, 1:일요일)
		cal.set(Calendar.DAY_OF_WEEK_IN_MONTH, 4);		//이 달의 몇째 요일
		
		Date date = cal.getTime();
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
	}
}