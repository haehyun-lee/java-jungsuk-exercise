package ch14;

import java.util.function.Function;
import java.util.function.Predicate;

// 함수형 인터페이스 합성
public class LambdaEx7 {
    public static void main(String[] args) {
        // Function 합성
        Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);   // 문자열을 16진수 정수로 변환
        Function<Integer, String> g = (i) -> Integer.toBinaryString(i);      // 정수를 2진수 문자열로 변환
        Function<String, String> h = f.andThen(g);
        Function<Integer, Integer> h2 = f.compose(g);

        System.out.println(h.apply("FF"));        // "FF" -> 255 -> 1111111
        System.out.println(h2.apply(2));          // 2 -> "10" -> 16

        Function<String, String> f2 = x -> x;       // 항등함수
        System.out.println(f2.apply("AAA"));     // AAA

        // Predicate 합성
        Predicate<Integer> p = i -> i < 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> r = i -> i % 2 == 0;
        Predicate<Integer> notP = p.negate();       // i >= 100

        Predicate<Integer> all = notP.and(q.or(r));
        System.out.println(all.test(150));       // true

        String str1 = "abc";
        String str2 = "abc";

        Predicate<String> p2 = Predicate.isEqual(str1);
        boolean result = p2.test(str2);
        System.out.println(result);                 // true
    }
}
