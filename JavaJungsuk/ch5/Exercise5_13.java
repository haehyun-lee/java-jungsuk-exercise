package ch5;

import java.util.Scanner;

public class Exercise5_13 {

	public static void main(String[] args) {
		String[] words = {"television", "computer", "mouse", "phone"};
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<words.length; i++) {
			char[] question = words[i].toCharArray();	//String을 char배열로 변환
			
			//char배열에 담긴 문자의 위치 섞기 (셔플)
			for(int j=0; j<question.length; j++) {
				int num = (int)(Math.random()*question.length);	//0~(배열크기-1) 사이 난수, 괄호위치 주의
				
				char tmp = question[j];
				question[j] = question[num];
				question[num] = tmp;
			}
			
			System.out.printf("Q%d. %s의 정답을 입력하세요.>", i+1, new String(question));	//char배열을 String으로 변환
			
			String answer = scanner.nextLine();
			
			//정답 체크
			if(words[i].equals(answer.trim())) {
				System.out.printf("맞았습니다.\n\n");
			}else {
				System.out.printf("틀렸습니다.\n\n");
			}
		}
	}
}
