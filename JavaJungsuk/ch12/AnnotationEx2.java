package ch12;

import java.util.ArrayList;

class NewClass{
    int newField;

    int getNewField() { return newField; }

    @Deprecated                                     // 더 이상 사용하지 않는 멤버
    int oldField;
    @Deprecated
    int getOldField() { return oldField; }
}

public class AnnotationEx2 {
    @SuppressWarnings("deprecation")                // deprecation관련 경고 억제
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;
        System.out.println(nc.getOldField());

        @SuppressWarnings("unchecked")              // 제네릭 관련 경고 억제
        ArrayList<NewClass> list = new ArrayList();
        list.add(nc);
    }
}
