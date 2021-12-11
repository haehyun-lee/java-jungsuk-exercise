package ch14;

@FunctionalInterface
interface MyFunction {
    void myMethod();
}

// 람다식에서 외부에 선언된 변수에 접근
class Outer {
    int val = 10;                   // Outer.this.val
    
    class Inner{    
        int val = 20;               // this.val

        void method(int i) {
            int val = 30;           // val
            
            // 함수형 인터페이스 내 추상메서드를 람다식으로 구현
            MyFunction f = () -> {
                System.out.println("             i :" + i);
                System.out.println("           val :" + val);
                System.out.println("      this.val :" + ++this.val);
                System.out.println("Outer.this.val :" + ++Outer.this.val);
            };
            
            f.myMethod();
        }
    }
}

public class LambdaEx3 {
    public static void main(String[] args) {
        Outer outer = new Outer();                  // 외부 클래스 인스턴스
        Outer.Inner inner = outer.new Inner();      // 내부 클래스 인스턴스 생성
        inner.method(100);
    }
}
