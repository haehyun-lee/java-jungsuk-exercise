package ch11;

import java.util.Iterator;

public class MyVector2Test {
    public static void main(String[] args) {
        MyVector2 v = new MyVector2();
        v.add("0");
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");

        System.out.println("삭제 전 : " + v);
        Iterator it = v.iterator();
        it.next();
        it.remove();        // 방금 읽은 요소 삭제
        it.next();
        it.remove();        // 방금 읽은 요소 삭제

        System.out.println("삭제 후 : " + v);      // 앞에서 두개 요소 삭제됨
    }
}
