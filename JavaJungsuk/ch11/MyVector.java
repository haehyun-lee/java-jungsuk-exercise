package ch11;

// Vector 클래스 구현
public class MyVector {
    Object[] data;   // 데이터 저장용 객체배열
    int capacity;       // 용량
    int size = 0;           // 크기

    // 생성자(용량)
    public MyVector(int capacity){
        if (capacity < 0) {
            throw new IllegalArgumentException("유효하지 않은 값입니다. :" + capacity);
        }

        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyVector(){
        this(10);       //크기를 지정하지 않을 시 기본 용량 10으로 생성
    }

    // 최소한의 용량(capacity) 확보
    public void ensureCapacity(int minCapacity) {
        // 용량이 초과할 경우
        if (minCapacity - data.length > 0) {
            setCapacity(minCapacity);
        }
    }

    // 추가
    public boolean add(Object obj) {
        ensureCapacity(size + 1);
        data[size++] = obj;
        return true;
    }

    // 값 반환
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }
        return data[index];
    }

    // 삭제(인덱스)
    public Object remove(int index) {
        Object oldObj;

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }
        oldObj = data[index];

        // 삭제하려는 객체가 마지막 요소가 아닐 경우, 빈자리 채우기
        if (index != size - 1) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        data[size-1] = null;
        size--;

        return oldObj;
    }

    // 삭제(처음으로 일치하는 객체)
    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    // 용량(capacity)을 실제 크기(size)에 맞추기
    public void trimToSize() {
        setCapacity(size);
    }
    
    // 용량 변경
    public void setCapacity(int capacity) {
        if (this.capacity == size) {
            return;
        }
        
        // 더 큰 크기로 새로 배열 생성해서 기존 데이터 옮기기
        Object[] tmp = new Object[capacity];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
        this.capacity = capacity;
    }

    // 모든 데이터 제거
    public void clear() {
        // data = null은 가리키는 배열 자체를 없애는 것, 빈 배열을 만들기 위해서는 각 요소를 null로
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    // 배열로 반환
    public Object[] toArray() {
        // data배열 그 자체를 넘기는 것이 아니라, 같은 값을 가진 복제 배열을 반환
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);

        return result;
    }
}