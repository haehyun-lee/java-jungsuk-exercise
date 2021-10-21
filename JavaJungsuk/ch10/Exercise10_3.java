package ch10;

import java.text.DecimalFormat;
import java.text.ParseException;

//Decimal Format - 반올림, 단위 구분자
public class Exercise10_3 {

	public static void main(String[] args) {
		String data = "123,456,789.5";
		
		DecimalFormat df1 = new DecimalFormat("#,###.#");
		DecimalFormat df2 = new DecimalFormat("#,####");
		
		Number num;
		try {
			num = df1.parse(data);
			double d = num.doubleValue();
			
			System.out.println("data : " + df1.format(d));
			System.out.println("반올림 : " + Math.round(d));
			System.out.println("만단위 : " + df2.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
