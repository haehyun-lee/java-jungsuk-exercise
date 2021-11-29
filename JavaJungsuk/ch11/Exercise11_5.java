package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// ArrayList & Comparable, compareTo()
class Student1 implements Comparable {
    String name;
    int ban;
    int no;
    int kor, eng, math;

    Student1(String name, int ban, int no, int kor, int eng, int math){
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
        return (kor + eng + math) / 3.0f;
    }

    public String toString() {
        return name + ", " + ban + ", " + no + ", " + kor + ", " + eng + ", " + math + ", "
                + getTotal() + ", " + getAverage();
    }

    // 기본 정렬기준을 구현 Comparable -> compareTo
    @Override
    public int compareTo(Object o) {
        if (o instanceof Student1) {
            String thisName = this.name;
            String anotherName = ((Student1)o).name;
            return thisName.compareTo(anotherName);    //String 클래스에 구현된 Comparator 활용
        }else{
            return -1;
        }
    }
}

public class Exercise11_5 {
    public static void main(String[] args) {
        ArrayList<Student1> list = new ArrayList<>();
        list.add(new Student1("홍길동", 1, 1, 100, 100, 100));
        list.add(new Student1("남궁성", 1, 2, 90, 70, 80));
        list.add(new Student1("김자바", 1, 3, 80, 80, 90));
        list.add(new Student1("이자바", 1, 4, 70, 90, 70));
        list.add(new Student1("안자바", 1, 5, 60, 100, 80));

        Collections.sort(list);
        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}