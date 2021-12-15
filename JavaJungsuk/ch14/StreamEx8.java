package ch14;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;    // Collectors 클래스의 static 메서드를 클래스명 없이 호출 가능

public class StreamEx8 {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),

                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200),
        };
        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<Student>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student::getBan));
        // Map<Integer, List<Student>> -> List<Student> -> Student
        for (List<Student> ban : stuByBan.values()) {
            for (Student s : ban) {
                System.out.println(s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        // 리턴된 Student.Level 값에 따라 Student 객체를 그룹핑
        Map<Student.Level, List<Student>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200)        return Student.Level.HIGH;
                    else if (s.getScore() >= 100)   return Student.Level.MID;
                    else                            return Student.Level.LOW;
                }));
//        List<Student> stdHigh = stdByLevel.get(Student.Level.HIGH);
        TreeSet<Student.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student.Level key : keySet) {
            System.out.println("[" + key + "]");
            for (Student s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<Student.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200)        return Student.Level.HIGH;
                    else if (s.getScore() >= 100)   return Student.Level.MID;
                    else                            return Student.Level.LOW;
                }, counting()));
        for (Student.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        }
        System.out.println();

        System.out.printf("%n4. 다중그룹화(학년별, 반별)%n");
        Map<Integer, Map<Integer, List<Student>>> stuByHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Student::getHak,
                        groupingBy(Student::getBan))
                );
        for (Map<Integer, List<Student>> hak : stuByHakAndBan.values()) {
            for (List<Student> ban : hak.values()) {
                System.out.println();
                for (Student s : ban)
                    System.out.println(s);
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student>> topStuHakAndBan = Stream.of(stuArr)
                .collect(groupingBy(Student::getHak,
                        groupingBy(Student::getBan,
                                collectingAndThen(
                                        maxBy(Comparator.comparingInt(Student::getScore))
                                        , Optional::get
                                )
                        )
                ));
        for (Map<Integer, Student> hak : topStuHakAndBan.values()) {
            for (Student s : hak.values()) {
                System.out.println(s);
            }
        }

        // 학년-반 하나의 문자열로 만들어 한번 그룹핑, 모든 Student 객체를 Student.Level로 매핑, Set으로 중복 제거
        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s -> {
                            if (s.getScore() >= 200) return Student.Level.HIGH;
                            else if (s.getScore() >= 100) return Student.Level.MID;
                            else return Student.Level.LOW;
                        }, toSet())));
        Set<String> keySet2 = stuByScoreGroup.keySet();
        for (String key : keySet2) {
            System.out.println("[" + key + "] " + stuByScoreGroup.get(key));
        }
    }
}
