package ch10;

import java.text.SimpleDateFormat;
import java.util.*;

//정해진 형식에 따라 입력받은 날짜의 요일 출력
public class Exercise10_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String pattern1 = "yyyy/MM/dd";
		String pattern2 = "입력하신 날짜는 E요일입니다.";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat(pattern1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);
		
		Date date = null;
		
		do {
			System.out.println("날짜를 " + pattern1 + "의 형태로 입력해주세요. (입력예:2021/10/22)");
			System.out.print(">>");
			
			try {
				date = sdf1.parse(sc.nextLine());		//예외가 발생하면 바로 catch문으로 이동
				break;									//예외가 발생 안하면 아래 break문까지 수행
			} catch(Exception e) { }
		} while(true);
		
		System.out.println(sdf2.format(date));
	}
}
