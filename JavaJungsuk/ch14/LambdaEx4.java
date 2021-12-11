package ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 컬렉션 프레임워크의 함수형 인터페이스를 사용하는 메서드
public class LambdaEx4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(i);
        }

        // list의 모든 요소 출력
        list.forEach(i -> System.out.print(i + ","));     // Consumer<T> action
        System.out.println();

        // list에서 2 또는 3의 배수를 제거
        list.removeIf(i -> i % 2 == 0 || i % 3 ==0);        // Predicate<E> filter
        System.out.println(list);

        // list의 각 요소에 10곱하기
        list.replaceAll(i -> i * 10);                       // UnaryOperator<E> operator
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        // map의 모든 요소를 {k, v} 의 형식으로 출력
        map.forEach((k, v) -> System.out.print("{" + k + ", " + v + "},"));   // BiConsumer<K, V> action
        System.out.println();

    }

}
