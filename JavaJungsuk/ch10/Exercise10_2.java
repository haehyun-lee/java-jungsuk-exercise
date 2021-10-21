package ch10;

import java.util.*;
import java.text.*;

public class Exercise10_2 {
	//두 날짜 사이에 월급날(매월 21일)이 몇번 있는지 계산해서 반환
	static int paycheckCount(Calendar from, Calendar to) {
		if(from == null || to == null)
			return 0;
		
		if(from.equals(to) && from.get(Calendar.DAY_OF_MONTH) == 21)
			return 1;
		
		//몇개월 차이
		int fromYear = from.get(Calendar.YEAR);
		int fromMon = from.get(Calendar.MONTH);
		int fromDay = from.get(Calendar.DAY_OF_MONTH);
		
		int toYear = to.get(Calendar.YEAR);
		int toMon = to.get(Calendar.MONTH);
		int toDay = to.get(Calendar.DAY_OF_MONTH);
		
		int monDiff = (toYear * 12 + toMon) - (fromYear * 12 + fromMon);
		if(monDiff < 0)
			return 1;
		
		//from이 21일이거나 이전이고 to가 21일이거나 이후일 경우
		if(fromDay <= 21 && toDay >= 21)
			monDiff++;							//MONTH는 0~11이기 때문에 한번만 증/감
		
		//from이 21일 이후고 to가 21일 이전일 경우
		if(fromDay > 21 && toDay < 21)
			monDiff--;
		
		return monDiff;
	}
	
	//형식화해서 출력
	static void printResult(Calendar from, Calendar to) {
		Date fromDate = from.getTime();
		Date toDate = to.getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.print(sdf.format(fromDate) + " ~ " + sdf.format(toDate) + ":");
		System.out.println(paycheckCount(from, to));
	}

	public static void main(String[] args) {
		Calendar fromCal = Calendar.getInstance();
		Calendar toCal = Calendar.getInstance();
		
		fromCal.set(2010, 0, 1);
		toCal.set(2010, 0, 1);
		printResult(fromCal, toCal);
		
		fromCal.set(2010, 0, 21);
		toCal.set(2010,  0, 21);
		printResult(fromCal, toCal);
		
		fromCal.set(2010, 0, 1);
		toCal.set(2010,  2, 1);
		printResult(fromCal, toCal);
		
		fromCal.set(2010, 0, 1);
		toCal.set(2010,  2, 23);
		printResult(fromCal, toCal);
		
		fromCal.set(2010, 0, 23);
		toCal.set(2010,  2, 21);
		printResult(fromCal, toCal);
		
		fromCal.set(2010, 0, 22);
		toCal.set(2010,  2, 21);
		printResult(fromCal, toCal);
	}
}
