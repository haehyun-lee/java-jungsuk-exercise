package ch14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CollectorEx1 {
    public static void main(String[] args) {
        String[] strArr = {"aaa", "bbb", "ccc"};
        Stream<String> strStream = Stream.of(strArr);

        String result = strStream.collect(new ConcatCollector());   // collect(Collector)

        System.out.println(Arrays.toString(strArr));
        System.out.println("result=" + result);
    }
}

class ConcatCollector implements Collector<String, StringBuilder, String> {
    // 메서드의 반환 타입이 함수형 인터페이스이기 때문에 람다식 반환
    @Override
    public Supplier<StringBuilder> supplier() {
        return () -> new StringBuilder();
//        return StringBuilder::new;
    }

    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sb, s) -> sb.append(s);
//        return StringBuilder::append;
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb, sb2) -> sb.append(sb);
//        return StringBuilder::append;
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return (sb) -> sb.toString();
//        return StringBuilder::toString
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();                  // 속성 지정 안함
    }
}
