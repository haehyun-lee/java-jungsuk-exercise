package ch09;

public class Exercise9_5 {
	//주어진 문자열에 찾으려는 문자열이 몇번 나오는지 세어서 반환
	public static int count(String src, String target) {
		int count = 0;	//찾은 횟수
		int pos = 0;	//찾기 시작할 위치
		
		while(true) {
			pos = src.indexOf(target, pos);	//찾은 target문자열의 첫번째 index
			
			if(pos != -1) {
				count++;
				pos += target.length();		//다음 시작 위치
			}else {
				break;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
		System.out.println(count("12345", "AB"));
	}
}