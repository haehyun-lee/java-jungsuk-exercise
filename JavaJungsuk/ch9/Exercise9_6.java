package ch9;

public class Exercise9_6 {
	//주어진 문자열(숫자)로 주어진 길이의 문자열을 만들고, 왼쪽 빈 공간은 0으로 채움
	public static String fillZero(String src, int length) {
		if(src == null || src.length()==length) {
			return src;
		} else if(length <= 0) {
			return "";
		} else if(src.length()>length) {
			return src.substring(0, length);
		}
		
		char[] chArr = new char[length];
		for(int i=0; i<chArr.length; i++) {
			chArr[i] = '0';
		}
		
		//배열 복사
		System.arraycopy(src.toCharArray(), 0, chArr, length-src.length(), src.length());
		
		return new String(chArr);			//String.valueOf(chArr);
	}
	
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src, 3));
	}
}
