package ch8;

public class Exercise8_6 {

	public static void main(String[] args) {
		try {
			method1();						//4. method1으로부터 예외를 받음
		} catch(Exception e) {
			System.out.println(5);			//5. 예외처리
		}
	}
	
	static void method1() {
		try {
			method2();						//2. method2로부터 예외를 받음, 처리할 catch문이 없어서 return
			System.out.println(1);
		} catch(ArithmeticException e) {
			System.out.println(2);
		} finally {
			System.out.println(3);			//3. try블록 return되어도 실행됨
		}
		
		System.out.println(4);
	}
	
	static void method2() {
		throw new NullPointerException(); 	//1. 예외 발생, method1에 예외처리 넘기기
	}
}
