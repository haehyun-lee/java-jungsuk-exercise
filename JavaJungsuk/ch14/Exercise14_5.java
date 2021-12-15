package ch14;

import java.util.stream.Stream;

// 문자열 배열의 모든 문자열의 길이를 더한 결과
public class Exercise14_5 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        int length = Stream.of(strArr)
                .mapToInt(s -> s.length()).sum();

        System.out.println("sum=" + length);
    }
}
