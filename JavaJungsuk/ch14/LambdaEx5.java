package ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 기본 제공 함수형 인터페이스
public class LambdaEx5 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;         // 매개변수X, 반환값O
        Consumer<Integer> c = i -> System.out.print(i + ", nnnnnnnnnnn");               // 매개변수O, 반환값X
        Predicate<Integer> p = i -> i % 2 == 0;                             // 매개변수O, 반환값 boolean = 조건식
        Function<Integer, Integer> f = i -> i/10*10;                        // 매개변수O, 반환값O

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);        // Supplier
        System.out.println(list);
        printEvenNum(p, c, list);       // Predicate, Consumer
        List<Integer> newList = doSomething(f, list);   // Function
        System.out.println(newList);
    }

    // List의 모든 요소에 Function을 수행한 값을 새로운 리스트로 반환
    static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));    // Function 매개변수 전달 및 반환값 얻기
        }

        return newList;
    }

    // List에서 Predicate 조건이 true인 요소만 Consumer 수행
    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i)) {        // Predicate 조건식 체크
                c.accept(i);        // Consumer 매개변수 전달
            }
        }
        System.out.println("]");
    }

    // List에 Supplier의 반환값을 요소로 추가
    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());      // Supplier 반환값 얻기
        }
    }
}
