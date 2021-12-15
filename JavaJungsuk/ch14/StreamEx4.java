package ch14;

import java.util.Optional;
import java.util.OptionalInt;

public class StreamEx4 {
    public static void main(String[] args) {
        // Optional 객체 값 가져오기
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);
        System.out.println("optStr=" + optStr.get());
        System.out.println("optInt=" + optInt.get());

        int result1 = Optional.of("123")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).get();

        // 값이 null일 경우 대체 값(-1) 반환
        int result2 = Optional.of("")
                .filter(x -> x.length() > 0)
                .map(Integer::parseInt).orElse(-1);

        System.out.println("result1=" + result1);
        System.out.println("result2=" + result2);

        // 값이 있으면 람다식 실행
        Optional.of("456").map(Integer::parseInt)
                .ifPresent(x -> System.out.printf("result3=%d%n", x));

        OptionalInt optInt1 = OptionalInt.of(0);      // 0 저장
        OptionalInt optInt2 = OptionalInt.empty();    // 빈 객체 생성

        // Optional 객체의 값이 null이면 false, 아니면 true
        System.out.println(optInt1.isPresent());
        System.out.println(optInt2.isPresent());

        // 0 - empty() 비교
        System.out.println(optInt1.getAsInt());         // 0
//        System.out.println(optInt2.getAsInt());       // NoSuchElementException
        System.out.println("optInt1=" + optInt1);       // OptionalInt[0]
        System.out.println("optInt2=" + optInt2);       // OptionalInt.empty
        System.out.println("optInt1.equals(optInt2)?" + optInt1.equals(optInt2));   // false

        // null - empty() 비교
        Optional<String> opt = Optional.ofNullable(null);               // null 저장
        Optional<String> opt2 = Optional.empty();                       // 빈 객체 생성
        System.out.println("opt=" + opt);                               // Optional.empty
        System.out.println("opt2=" + opt2);                             // Optional.empty
        System.out.println("opt.equals(opt2)?" + opt.equals(opt2));     // true

        int result3 = optStrToInt(Optional.of("123"), 0);    // 123
        int result4 = optStrToInt(Optional.of(""), 0);       // 0

        System.out.println("result3=" + result3);
        System.out.println("result4=" + result4);
    }

    // 문자열 -> 정수 변환 시 예외 발생하면 대체 값 반환
    static int optStrToInt(Optional<String> optStr, int defaultValue) {
        try {
            return optStr.map(Integer::parseInt).get();
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
