package ch14;

@FunctionalInterface
interface MyFunction2 {
    void myMethod();
}

public class LambdaEx2 {
    public static void main(String[] args) {
        MyFunction2 f = () ->{};                 // MyFunction f = (MyFunction)(()->{});
        Object obj = (MyFunction2) (()->{});     // 람다식은 Object 타입으로 바로 형변환 불가, 함수형 인터페이스로만 형변환 가능
        String str = ((Object)(MyFunction2)(()->{})).toString();

        System.out.println(f);                  // 함수형 인터페이스
        System.out.println(obj);                // Object
        System.out.println(str);                // String

        System.out.println((MyFunction2)(()->{}));
        System.out.println(((Object)(MyFunction2)(()->{})).toString());
    }
}
