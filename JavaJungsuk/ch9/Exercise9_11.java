package ch9;
public class Exercise9_11 {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("시작 단과 끝 단, 두 개의 정수를 입력하세요.\nUSAGE : GuGudanTest 3 5");
			System.exit(0);			
		}
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		if((num1 < 2 || num1 > 9) || (num2 < 2 || num2 > 9 )) {
			System.out.println("단의 범위는 2와 9사이의 값이어야 합니다.\nUSAGE : GuGudanTest 3 5");
			System.exit(0);	
		}
		
		for(int i=num1; i<=num2; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%d*%d=%d\n", i, j, i*j);
			}
			System.out.println();
		}
	}
}