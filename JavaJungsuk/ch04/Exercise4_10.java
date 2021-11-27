package ch04;

public class Exercise4_10 {

	public static void main(String[] args) {
		int num = 12345;
		int sum =0;
		
		do {
			sum += (num % 10);		//1의 자리 값 (뒤에서부터 처리)
		}while((num /= 10) != 0);	//1의 자리 값 떼어내기, 1의 자리만 남을 때까지 반복
		
		System.out.println("sum="+sum);
	}
}
