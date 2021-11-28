package ch11;

import java.util.*;

// 반 등수 계산
class Student implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    int total;          // 총점
    int schoolRank;     // 전교등수
    int classRank;      // 반등수

    Student(String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        total = kor + eng + math;
    }

    int getTotal() {
        return total;
    }

    float getAverage() {
        return Math.round(getTotal() / 3f * 10) / 10f;  //소수점 2번째 자리에서 반올림
    }

    public String toString() {
        return name
                + ", " + ban
                + ", " + no
                + ", " + kor
                + ", " + eng
                + ", " + math
                + ", " + getTotal()
                + ", " + getAverage()
                + ", " + schoolRank
                + ", " + classRank
                ;
    }

    // 기본 정렬 (총점 내림차순)
    @Override
    public int compareTo(Object o) {
        if (o instanceof Student) {
            Student tmp = (Student) o;
            return tmp.total - this.total;       //내림차순은 반대로
        } else {
            return -1;
        }
    }
}

class ClassTotalComparator implements Comparator{
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student std1 = (Student)o1;
            Student std2 = (Student)o2;
            
            // 반이 다르면 반오름차순, 반이 같으면 총점 내림차순 정렬
            if(std1.ban == std2.ban){
                return std2.total - std1.total;
            }else{
                return std1.ban - std2.ban;
            }
        } else {
            return -1;
        }
    }
}

public class Exercise11_9 {
    // 반별 등수 계산
    public static void calculateClassRank(List<Student> list){
        // 반별 총점기준 내림차순
        Collections.sort(list, new ClassTotalComparator());
        
        int prevBan = -1;
        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();

        for (int i = 0, n = 0; i < length; i++, n++) {
            Student std = (Student)list.get(i);

            // 반이 바뀌면 초기화
            if (std.ban != prevBan) {
                prevRank = -1;
                prevTotal = -1;
                n = 0;
            }

            if(std.total == prevTotal){
                std.classRank = prevRank;
            }else{
                std.classRank = n + 1;
            }

            prevBan = std.ban;
            prevTotal = std.total;
            prevRank = std.classRank;
        }
    }
    
    // 전체 등수 계산
    public static void calculateSchoolRank(List<Student> list) {
        Collections.sort(list);

        int prevRank = -1;
        int prevTotal = -1;
        int length = list.size();

        for (int i = 0; i < length; i++) {
            Student std = (Student)list.get(i);

            if (std.total == prevTotal) {
                std.schoolRank = prevRank;      //조건에 따라 각각 다른 값을 부여, 결과만 제대로 나오면 됨
            } else {
                std.schoolRank = i+1;           //list가 이미 total 내림차순으로 정렬되어 있기에 가능
            }
            prevTotal = std.total;
            prevRank = std.schoolRank;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("이자바", 2, 1, 70, 90, 70));
        list.add(new Student("안자바", 2, 2, 60, 100, 80));
        list.add(new Student("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student("김자바", 1, 2, 80, 80, 90));
        
        calculateSchoolRank(list);
        calculateClassRank(list);

        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
