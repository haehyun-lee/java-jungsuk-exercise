package ch11;

import java.util.Iterator;

public class MyVector2 extends MyVector implements Iterator {
    int cursor = 0;         // 앞으로 읽어 올 요소의 위치
    int lastRet = -1;       // 마지막으로 읽어 온 요소의 위치 (remove 용)

    public MyVector2(int capacity) {
        super(capacity);
    }

    public MyVector2() {
        super(10);
    }

    public String toString() {
        String tmp = "";
        Iterator it = iterator();

        for (int i = 0; it.hasNext(); i++) {
            if(i != 0) tmp += ", ";
            tmp += it.next();
        }
        return "[" + tmp + "]";
    }

    // List 인터페이스를 구현한 MyVector 클래스가 오버라이딩한 iterator() 메서드를 다시 오버라이딩
    public Iterator iterator() {
        cursor = 0;
        lastRet = -1;
        return this;
    }

    @Override
    public boolean hasNext() {
        return cursor != size;
    }

    @Override
    public Object next() {
        Object next = get(cursor);
        lastRet = cursor++;
        return next;
    }

    public void remove() {
        // next()를 호출한 적 없음, 읽어 온 값이 없음
        if (lastRet == -1) {
            throw new IllegalArgumentException();
        } else {
            remove(lastRet);
            cursor--;           // 삭제된 요소의 위치를 채우기 위해 뒷 요소들이 당겨지므로
            lastRet = -1;       // 초기화
        }
    }
}
