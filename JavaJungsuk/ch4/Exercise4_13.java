package ch4;

public class Exercise4_13 {

	public static void main(String[] args) {
		String value = "12o34";
		char ch = ' ';
		boolean isNumber = true;
		
		//문자열의 문자를 하나씩 읽어서 숫자인지 검사
		for(int i =0; i<value.length(); i++) {
			ch = value.charAt(i);
			if(!(ch>='0' && ch<='9')) {
				isNumber = false;
				break;	//한 문자라도 숫자가 아닐경우 검사 중단
			}
		}
		
		if(isNumber) {
			System.out.println(value+"는 숫자입니다.");
		}else {
			System.out.println(value+"는 숫자가 아닙니다.");
		}
	}

}
