package ch9;

public class Exercise9_11_new {

	public static void main(String[] args) {
		int from = 0;
		int to = 0;
		
		try {
			if(args.length != 2) {
				throw new Exception("시작 단과 끝 단, 두 개의 정수를 입력하세요.");	//예외 발생(메시지)
			}
			
			from = Integer.parseInt(args[0]);
			to = Integer.parseInt(args[1]);
			
			if(!(2 <= from && from <=9 && 2 <= to && to <= 9)) {
				throw new Exception("단의 범위는 2와 9사이의 값이어야 합니다.");
			}
		} catch(Exception e) {
			//예외 발생시 중복 코드
			System.out.println("USAGE : GuGudanTest 3 5");
			System.exit(0);	
		}
		
		//작은 단을 앞으로 (시작단~끝단)
		if(from > to) {
			int tmp = from;
			from = to;
			to = tmp;
		}
				
		
		for(int i=from; i<=to; i++) {
			for(int j=1; j<=9; j++) {
				System.out.printf("%d*%d=%d\n", i, j, i*j);
			}
			System.out.println();
		}
	}
}
