package ch09;

public class Exercose9_9 {
	//주어진 문자열에서 금지된 문자들을 제거하여 반환
	public static String delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer(src.length());
		
		for(int i=0; i<src.length(); i++) {
			char ch = src.charAt(i);
			
			//지울 문자열에서 기준 문자 하나씩 탐색 (탐색 기준을 반대로)
			if(delCh.indexOf(ch) == -1) {
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" -> "
									+ delChar("1!2@3^4~5", "~!@#$%^&*()"));
		System.out.println("(12    3   4\t5)"+" -> "
									+ delChar("(12    3   4\t5)", " \t"));
	}

}
