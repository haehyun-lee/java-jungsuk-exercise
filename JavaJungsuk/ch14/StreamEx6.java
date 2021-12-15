package ch14;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 스트림 collect(), Collector 인터페이스, Collectors 클래스 static 메서드
public class StreamEx6 {
    public static void main(String[] args) {
        Student1[] stuArr = {
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 290),
                new Student1("강자바", 3, 180)
        };

        // 학생 이름만 뽑아서 List<String>에 저장
        List<String> names = Stream.of(stuArr).map(Student1::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        // 스트림을 배열로 변환
        Student1[] stuArr2 = Stream.of(stuArr).toArray(Student1[]::new);
        for (Student1 s : stuArr2) {
            System.out.println(s);
        }

        // 스트림을 Map<String, Student> 로 변환, 학생이름이 key
        Map<String, Student1> stuMap = Stream.of(stuArr)
                .collect(Collectors.toMap(s -> s.getName(), Function.identity()));

        for (String name : stuMap.keySet()) {
            System.out.println(name + stuMap.get(name));
        }

        // counting(), summingInt()
        long count = Stream.of(stuArr)
                .collect(Collectors.counting());
        long totalScore = Stream.of(stuArr)
                .collect(Collectors.summingInt(Student1::getTotalScore));     // 각 스트림 Student 요소에 대한 getTotalScore() 반환 값의 총합을 구함

        System.out.println("count=" + count);
        System.out.println("totalScore=" + totalScore);

        // reducing() <= summingInt() & map()
        totalScore = Stream.of(stuArr).collect(Collectors
                .reducing(0, Student1::getTotalScore, Integer::sum));
        System.out.println("totalScore=" + totalScore);

        // maxBy()
        Optional<Student1> topStudent = Stream.of(stuArr)
                .collect(Collectors.maxBy(Comparator.comparingInt(Student1::getTotalScore)));
        System.out.println("topStudent=" + topStudent.get());

        // summarizing() - count, sum, min, average, max
        IntSummaryStatistics stat = Stream.of(stuArr)
                .collect(Collectors.summarizingInt(Student1::getTotalScore));
        System.out.println(stat);

        // joining()
        String stuNames = Stream.of(stuArr).map(Student1::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println(stuNames);
    }
}