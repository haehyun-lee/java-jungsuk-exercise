package ch08;

/**
 * 예외 되던지기 예제
 * 호출한 메서드에서 throw한 예외를 catch문에서 처리하는 도중에 예외를 다시 throw함
 */

public class Exercise8_10 {

	public static void main(String[] args) {
		try {
			method1();							//6. method1에서 발생한 예외 넘겨받음
			System.out.println(6);
		} catch(Exception e) {
			System.out.println(7);				//7. 예외처리
		}
	}
	
	static void method1() {
		try {
			method2();							//2. method2에서 발생한 예외 넘겨받음
			System.out.println(1);
		} catch(NullPointerException e) {
			System.out.println(2);				//3. 예외처리
			throw e;							//4. 예외 되던지기(re-throwing)
		} catch(Exception e) {
			System.out.println(3);
		} finally {
			System.out.println(4);				//5. finally블록은 try, catch 모두에서 실행됨
		}
	}
	
	static void method2() {
		throw new NullPointerException();		//1. 예외 발생, 던지기
	}
}
