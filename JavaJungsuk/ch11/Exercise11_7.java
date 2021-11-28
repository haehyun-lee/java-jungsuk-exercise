package ch11;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// ArraysList & Comparator, compare
class Student {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student(String name, int ban, int no, int kor, int eng, int math){
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
}

class BanNoAscending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student std1 = (Student)o1;
            Student std2 = (Student)o2;
            // 반이 같을 경우 no 오름차순, 다를 경우 그대로 ban 오름차순
            if (std1.ban != std2.ban) {
                return std1.ban - std2.ban;
            } else {
                return std1.no - std2.no;
            }
        }else {
            return -1;
        }
    }
}

public class Exercise11_7 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("이자바", 2, 1, 70, 90, 70));
        list.add(new Student("안자바", 2, 2, 60, 100, 100));
        list.add(new Student("홍길동", 1, 3, 100, 100, 100));
        list.add(new Student("남궁성", 1, 1, 90, 70, 80));
        list.add(new Student("김자바", 1, 2, 80, 80, 90));

        Collections.sort(list, new BanNoAscending());

        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
