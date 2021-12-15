package ch14;

import java.util.Comparator;
import java.util.stream.Stream;

// Stream 정렬
public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student1> studentStream = Stream.of(
                new Student1("이자바", 3, 300),
                new Student1("김자바", 1, 200),
                new Student1("안자바", 2, 100),
                new Student1("박자바", 2, 150),
                new Student1("소자바", 1, 200),
                new Student1("나자바", 3, 290),
                new Student1("김자바", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student1::getBan)      // 반별 오름차순
                .thenComparing(Comparator.naturalOrder()))              // 기본 정렬 (총점 내림차순)
                .forEach(System.out::println);
    }
}

class Student1 implements Comparable<Student1> {
    String name;
    int ban;
    int totalScore;

    Student1(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName() { return name; }
    int getBan() { return ban; }
    int getTotalScore() { return totalScore; }

    // 총점 내림차순 기본 정렬
    @Override
    public int compareTo(Student1 s) {
        return s.totalScore - this.totalScore;
    }
}
