package ch7;

class Outer{
	int value = 10;			//외부클래스 인스턴스 변수
	
	class Inner{
		int value = 20;		//내부클래스 인스턴스 변수
		void method1() {
			int value = 30;	//내부클래스 내 메서드의 지역변수
			
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer.this.value);
		}
	}
}

public class Exercise7_25 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();

		inner.method1();
	}
}
