package ch4;

public class FlowEx29 {

	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.printf("i=%d ", i);

			int tmp = i;
			
			do {
				//1의 자리 수 떼어서 3의 배수인지 확인
				if(tmp%10%3==0 && tmp%10!=0) {
					System.out.print("짝");
				}
			//모든 작업은 위에서 수행됨. 값이 1의 자리만 남았을 경우, 자리수 떼기 종료 (1의 자리수를 하나씩 떼어가며 369확인)
			} while((tmp/=10)!=0);
			System.out.println();
		}
	}
}
