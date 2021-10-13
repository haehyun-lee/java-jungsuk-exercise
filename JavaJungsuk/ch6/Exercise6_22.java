package ch6;

public class Exercise6_22 {

	public static boolean isNumber(String str) {
		if(str == null || str.equals("")) {
			return false;
		}
		
		char[] chArr = str.toCharArray();
		for(int i=0; i<chArr.length; i++) {
			char ch = chArr[i];
			if(ch < '0' && ch >'9') {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
	}

}
