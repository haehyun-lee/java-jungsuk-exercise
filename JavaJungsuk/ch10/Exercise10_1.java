package ch10;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exercise10_1 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2010, 0, 1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일 입니다.");		
		
		for(int i=0; i<12; i++) {
			int weekday = cal.get(Calendar.DAY_OF_WEEK);				//1일의 요일
			
			int secondSunday = (weekday == 1) ? 8 : (16 - weekday);		//2번째 일요일의 일
			
			cal.set(Calendar.DAY_OF_MONTH, secondSunday);
			
			Date date = cal.getTime();			
			System.out.println(sdf.format(date));
			
			cal.add(Calendar.MONDAY, 1);		//다음달
			cal.set(Calendar.DAY_OF_MONTH, 1);	//해당 월의 1일로
		}
	}
}
