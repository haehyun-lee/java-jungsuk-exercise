package ch14;

import java.util.Arrays;
import java.util.stream.Stream;

// Stream<Stream<String>> → Stream<String[]> → Stream<String>
// map(), flatMap() : Stream 요소를 변환
public class StreamEx3 {
    public static void main(String[] args) {
        Stream<String[]> strArrStrm = Stream.of(
                new String[] {"abc", "def", "jkl"},
                new String[] {"ABC", "DEF", "JKL"}
        );

        // Stream<String[]> → Stream<String>
//        Stream<Stream<String>> strStrmStrm = strArrStrm.map(Arrays::stream);
        Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);        // Arrays.stream(String[] arr) : 배열을 스트림으로 변환

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // String[] → Stream<String>
        String[] lineArr = {
                "Believe or not It is true",
                "Do or do not There is no try"
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))     // 생성된 Stream<String>을 풀고 요소로 취급
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
        Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

        Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
        Stream<String> strStream = strStrmStrm
                .map(s -> s.toArray(String[]::new))     // Stream<Stream<String>> → Stream<String[]>
                .flatMap(Arrays::stream);               // Stream<String[]> → Stream<String>
        strStream.map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }
}
