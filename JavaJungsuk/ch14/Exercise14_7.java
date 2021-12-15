package ch14;

import java.util.Random;

// 임의의 로또번호(1~45)를 정렬해서 출력
public class Exercise14_7 {
    public static void main(String[] args) {
        Random random = new Random();
        // 지정된 범위의 난수를 발생시키는 무한스트림, 중복제거, 6개 자르기, 정렬, 출력
        random.ints(1, 46)
                .distinct()
                .limit(6)
                .sorted()
                .forEach(System.out::println);
    }
}