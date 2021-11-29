package ch11;

import java.util.*;

// TreeSet 정렬 기준 Comparator
class Student2 implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student2(String name, int ban, int no, int kor, int eng, int math){
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int getTotal() {
        return kor + eng + math;
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
                ;
    }

    // 기본 정렬 기준(학생 이름순)
    @Override
    public int compareTo(Object o) {
        if (o instanceof Student2) {
            Student2 tmp = (Student2) o;
            return name.compareTo(tmp.name);
        } else {
            return -1;
        }
    }
}

public class Exercise11_6 {
    static int getGroupCount(TreeSet tset, int from, int to) {
        // 요소가 객체이기 때문에 범위 검색 값도 해당 객체로
        Student2 std1 = new Student2("", 0, 0, from, from, from);
        Student2 std2 = new Student2("", 0, 0, to, to, to);

        SortedSet set = tset.subSet(std1, std2);
        return set.toArray().length;
    }

    public static void main(String[] args) {
        TreeSet<Student2> tset = new TreeSet<>(new Comparator() {
            // 기본 정렬 기준 외 별도의 기준으로 정렬 (학생 평균순)
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student2 && o2 instanceof Student2) {
                    Student2 std1 = (Student2)o1;
                    Student2 std2 = (Student2)o2;
                    // o1 > o2 => 양수, o1 == o2 => 0, o1 < o2 => 음수
                    return (int)(std1.getAverage() - std2.getAverage());
                }else{
                    return -1;
                }
            }
        }) ;

        // TreeSet은 값이 추가될 때마다 기준에 따라 자동 정렬됨
        tset.add(new Student2("홍길동", 1, 1, 100, 100, 100));
        tset.add(new Student2("남궁성", 1, 2, 90, 70, 80));
        tset.add(new Student2("김자바", 1, 3, 80, 80, 90));
        tset.add(new Student2("이자바", 1, 4, 70, 90, 70));
        tset.add(new Student2("안자바", 1, 5, 60, 100, 80));    //남궁성과 평균 값이 중복되어 추가 안됨

        Iterator it = tset.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("[60~69] : " + getGroupCount(tset, 60, 70));
        System.out.println("[70~79] : " + getGroupCount(tset, 70, 80));
        System.out.println("[80~89] : " + getGroupCount(tset, 80, 90));
        System.out.println("[90~100] : " + getGroupCount(tset, 90, 100));
    }
}
