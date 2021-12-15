package ch14;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

// 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여 출력
public class Exercise14_8 {
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

        Map<Boolean, Map<Boolean, Long>> failedStuBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student::isMale,
                        partitioningBy(s -> s.getScore() < 150, counting())));
        
        long failedMaleStuNum = failedStuBySex.get(true).get(true);
        long failedFemaleStuNum = failedStuBySex.get(false).get(true);

        System.out.println("불합격[남자]:" + failedMaleStuNum + "명");
        System.out.println("불합격[여자]:" + failedFemaleStuNum + "명");
    }
}
