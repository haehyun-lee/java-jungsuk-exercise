package ch09;

public class Exercise9_10 {
	/**
	 * 주어진 문자열을 지정된 크기의 문자열로 변환, 나머지 자리는 공백으로 채움 
	 * @param str	변환할 문자열
	 * @param length	변환된 문자열의 길이
	 * @param alignment	변환된 문자열의 정렬조건 (0: 왼쪽정렬, 1:가운데 정렬, 2: 오른족 정렬)
	 * @return	변환된 문자열
	 */
	public static String format(String str, int length, int alignment) {
		int diffLen = length - str.length();
		if(diffLen < 0) { return str.substring(length); }
		
		char[] source = str.toCharArray();	//자주쓰는 것은 변수로 선언해두기
		char[] result = new char[length];
		
		for(int i=0; i<result.length; i++) {
			result[i] = ' ';
		}
		
		switch(alignment) {
			case 0:
				System.arraycopy(source, 0, result, 0, source.length);
				break;
			case 1:
				System.arraycopy(source, 0, result, diffLen/2, source.length);
				break;
			case 2:
				System.arraycopy(source, 0, result, diffLen, source.length);
				break;
		}
		
		return new String(result);
	}
	
	public static void main(String[] args) {
		String str = "가나다";
		
		System.out.println(format(str, 7, 0));	//왼쪽 정렬
		System.out.println(format(str, 7, 1));	//가운데 정렬
		System.out.println(format(str, 7, 2));	//오른쪽 정렬
	}

}
