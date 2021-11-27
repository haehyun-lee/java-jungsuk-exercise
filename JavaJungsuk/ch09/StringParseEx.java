package ch09;

import java.util.*;

public class StringParseEx {
	public static void main(String[] args) {
		//1~100사이의 임의의 값을 얻어서 answer에 저장
		int answer = (int)(Math.random()*100 + 1);
		String inputStr;	//사용자 입력 값
		int inputNum;
		
		do {
			System.out.print("1과 100사이의 값을 입력하세요 :");
			try {
				inputStr = new Scanner(System.in).nextLine();
				inputNum = Integer.parseInt(inputStr.trim());			//공백제거 후 형변환
			} catch(NumberFormatException e) {
				System.out.println("유효하지 않은 값입니다. 다시 입력하세요.");	//예외 발생시 다시 입력받기
				continue;
			}
			
			if(answer > inputNum) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if(answer < inputNum) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("맞췄습니다.");
				break;
			}
		} while(true);
	}
}