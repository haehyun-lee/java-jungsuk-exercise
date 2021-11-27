package ch04;

import java.util.*;

public class FlowEx28 {

	public static void main(String[] args) {
		int input = 0, answer = 0;

		Scanner scanner = new Scanner(System.in);
		answer = (int) (Math.random() * 100) + 1;
		
		do {
			System.out.print("1부터 100사이의 정수를 입력하세요.>");
		    input = scanner.nextInt();
		    
		    if(input>answer) {
		    	System.out.println("Down");
		    }else if(input < answer) {
		    	System.out.println("Up");
		    }
		} while(input!=answer);

		System.out.println("정답!");
	}
}
