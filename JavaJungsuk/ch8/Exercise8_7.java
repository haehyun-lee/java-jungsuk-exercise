package ch8;

public class Exercise8_7 {

	static void method(boolean b) {
		try {
			System.out.println(1);	//2. 1출력
			if(b) System.exit(0);	//3. 프로그램 종료
			System.out.println(2);
		} catch(RuntimeException e) {
			System.out.println(3);
			return;
		} catch(Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		}
		
		System.out.println(6);
	}
	
	public static void main(String[] args) {
		method(true);				//1. method호출
		method(false);
	}

}
