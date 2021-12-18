package ch11;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx2 {
    public static void main(String[] args) {
        ArrayList original = new ArrayList();
        ArrayList copy1 = new ArrayList();
        ArrayList copy2 = new ArrayList();

        for (int i = 0; i < 10; i++) {
            original.add(i + "");
        }

        // 복사
        Iterator it = original.iterator();
        while (it.hasNext()) {
            copy1.add(it.next());
        }

        System.out.println("= Original에서 copy1로 복사(copy) =");
        System.out.println("original:" + original);
        System.out.println("copy1:" + copy1);
        System.out.println();

        // 이동 (잘라내기)
        it = original.iterator();
        while (it.hasNext()) {
            copy2.add(it.next());
            it.remove();            // next()로 읽어 온 요소를 삭제
        }

        System.out.println("= Original에서 copy2로 복사(copy) =");
        System.out.println("original:" + original);
        System.out.println("copy2:" + copy2);
        System.out.println();
    }
}
