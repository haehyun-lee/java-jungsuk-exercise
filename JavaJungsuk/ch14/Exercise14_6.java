package ch14;

import java.util.stream.Stream;

// 문자열 배열의 문자열 중 가장 긴 것의 길이
public class Exercise14_6 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bb", "c", "dddd"};

        int maxLen = Stream.of(strArr).mapToInt(s -> s.length()).max().getAsInt();

        System.out.println(maxLen);
    }
}
