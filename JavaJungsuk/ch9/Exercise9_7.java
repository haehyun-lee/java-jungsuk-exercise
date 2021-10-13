package ch9;

public class Exercise9_7 {
	//첫번재 문자열에 두번째 문자열이 포함되어 있는지 확인
	public static boolean contains(String src, String target) {
		return src.indexOf(target) != -1;
//		return src.indexOf(target) != -1 ? true : false;
	}
 
	public static void main(String[] args) {
		System.out.println(contains("12345", "23"));
		System.out.println(contains("12345", "67"));
	}
}