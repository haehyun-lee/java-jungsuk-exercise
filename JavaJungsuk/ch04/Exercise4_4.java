package ch04;

public class Exercise4_4 {

	public static void main(String[] args) {
		int sum = 0;
		int i =1;
		String expression = "";
		
		while(true) {
			//짝수는 빼기, 홀수는 더하기
			if(i%2==0) {
				sum -= i;
				expression += String.format("-%d", i);
			}else {
				sum += i;
				expression += String.format("+%d", i);
			}
			
			if(sum >= 100) {
				break;
			}
			i++;
		}
		System.out.printf("%s\n", expression);		//계산과정 확인
		System.out.printf("i: %d sum: %d", i, sum);
	}
}
