package ch4;

public class Exercise4_11 {

	public static void main(String[] args) {
		//Fibonacci 수열의 시작의 첫 두 숫자를 1, 1로 한다.
		int num1 = 1;
		int num2 = 1;
		int num3 = 0;
		System.out.print(num1+", "+num2);	//고정값은 미리 출력
		
		for(int i =0; i<8; i++) {
			num3 = num1+num2;
			System.out.print(", "+num3);
			
			//앞의 두 수 새로 지정
			num1 = num2;
			num2 = num3;
		}
	}
}
