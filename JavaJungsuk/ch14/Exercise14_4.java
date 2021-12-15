package ch14;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 두 개의 주사위를 던져 눈의 합이 6인 경우
public class Exercise14_4 {
    public static void main(String[] args) {
        // 지정된 범위의 연속된 정수를 스트림으로 생성
        Stream<Integer> dice = IntStream.rangeClosed(1, 6).boxed();

        // {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}
        // {2, 1}, {2, 2}, ..., {6, 6}
        dice.flatMap(i -> Stream.of(1, 2, 3, 4, 5, 6).map(i2 -> new int[]{i, i2}))
                .filter(iArr -> iArr[0] + iArr[1] == 6)
                .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
