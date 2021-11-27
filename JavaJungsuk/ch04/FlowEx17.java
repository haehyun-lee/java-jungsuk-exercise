package ch04;

import java.util.*;

public class FlowEx17 {

	public static void main(String[] args) {
		System.out.print("*을 출력할 라인의 수를 입력하세요.>");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		for(int i=1; i<=num; i++) {		//몇줄?
			for(int j=1; j<=i; j++) {	//몇개?
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
