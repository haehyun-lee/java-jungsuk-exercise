package ch14;

@FunctionalInterface        // 함수형 인터페이스 Annotation
interface MyFunction1 {
    void run();             // 추상메서드
}

public class LambdaEx1 {
    // 매개변수 타입이 함수형 인터페이스
    static void execute(MyFunction1 f) {
        f.run();
    }

    // 반환 타입이 함수형 인터페이스
    static MyFunction1 getMyFunction() {
        MyFunction1 f = () -> System.out.println("f3.run()");
        return f;           // 람다식 메서드를 객체로 반환
    }

    public static void main(String[] args) {
        MyFunction1 f1 = () -> System.out.println("f1.run()");

        MyFunction1 f2 = new MyFunction1() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction1 f3 = getMyFunction();                // 메서드로부터 반환된 람다식을 객체에 저장

        f1.run();
        f2.run();
        f3.run();

        execute(f1);                                    // 람다식을 참조하는 참조변수를 매개변수로 전달 
        execute(() -> System.out.println("run()"));     // 람다식 자체를 매개변수로 전달
    }
}
