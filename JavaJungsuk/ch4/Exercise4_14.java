package ch4;

public class Exercise4_14 {

	public static void main(String[] args) {
		int answer = (int)(Math.random()*100)+1;	//1~100 사이 임의의 값
		int input = 0;	//사용자 입력
		int count = 0;	//시도 횟수
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 :");
			input = scan.nextInt();
			
			if(input<answer) {
				System.out.println("더 큰 값을 입력하세요.");
			}else if(input>answer) {
				System.out.println("더 작은 값을 입력하세요.");
			}else {
				System.out.printf("맞췄습니다.\n시도횟수는 %d번입니다.", count);
				break;
			}
		}while(true);
		
		scan.close();
	}
}
