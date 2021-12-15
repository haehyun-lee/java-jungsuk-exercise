package ch14;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 스트림 최종 연산
public class StreamEx5 {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        Stream.of(strArr).forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);                     // 조건 비매칭 여부
        Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();     // 필터링 결과 중 첫번째 요소 반환

        System.out.println("noEmptyStr=" + noEmptyStr);     // false
        System.out.println("sWord=" + sWord.get());         // stream

        // Stream<String[]> 을 IntStream으로 변환
        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        // reduce(int identity, IntBinaryOperator op) -> int
        int count = intStream1.reduce(0, (a, b) -> a + 1);   // 8
        int sum = intStream2.reduce(0, (a, b) -> a + b);     // 58

        // reduce(IntBinaryOperator op) -> OptionalInt
        OptionalInt max = intStream3.reduce(Integer::max);          // intStream3.reduce((a, b) -> a > b ? a : b)
        OptionalInt min = intStream4.reduce(Integer::min);          // intStream4.reduce((a, b) -> a < b ? a : b)

        System.out.println("count=" + count);
        System.out.println("sum=" + sum);
        System.out.println("max=" + max.getAsInt());    // OptionalInt[14].getAsInt()
        System.out.println("min=" + min.getAsInt());    // OptionalInt[3].getAsInt()
    }
}
