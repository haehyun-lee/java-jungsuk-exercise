package ch4;

public class Exercise4_9 {

	public static void main(String[] args) {
		String str = "12345";
		int sum =0;
		
		//문자열의 각 문자를 차례대로 정수로 변환
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);	//문자열의 i번재 문자 반환
			int num = ch-'0';			//각 자리는 유니코드 정수('0'~'9') 중 하나로, 값에서 '0'을 빼면 순수 정수 추출 가능
			
			sum += num;
		}
		System.out.println("sum="+sum);
	}
}