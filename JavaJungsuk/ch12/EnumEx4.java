package ch12;

// 클래스(class)로 열거형(enum) 구조 구현 
// 열거형 구조
abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0;
    int ordinal;
    String name = "";

    public int ordinal() { return ordinal; }

    MyEnum(String name) {
        this.name = name;
        this.ordinal = id++;
    }

    // 타입 T는 반드시 MyEnum의 자손이기 때문에 MyEnum의 멤버를 모두 가지고 있음
    public int compareTo(T t) {
        return this.ordinal - t.ordinal;     // 순번 오름차순 정렬
    }
}

// 사용자 정의 열거형
abstract class MyTransportation extends MyEnum {
    static final MyTransportation BUS = new MyTransportation("BUS", 100){
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation TRAIN = new MyTransportation("TRAIN", 150) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation SHIP = new MyTransportation("SHIP", 100) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };
    static final MyTransportation AIRLINE = new MyTransportation("AIRLINE", 300) {
        int fare(int distance) { return distance * BASIC_FARE; }
    };

    abstract int fare(int distance);       // 추상메서드

    protected final int BASIC_FARE;

    private MyTransportation(String name, int basicFare) {
        super(name);
        BASIC_FARE = basicFare;
    }

    public String name() { return name; }
    public String toString() { return name; }
}

public class EnumEx4 {
    public static void main(String[] args) {
        MyTransportation t1 = MyTransportation.BUS;
        MyTransportation t2 = MyTransportation.BUS;
        MyTransportation t3 = MyTransportation.TRAIN;
        MyTransportation t4 = MyTransportation.SHIP;
        MyTransportation t5 = MyTransportation.AIRLINE;

        System.out.printf("t1=%s, %d%n", t1.name(), t1.ordinal());
        System.out.printf("t1=%s, %d%n", t2.name(), t2.ordinal());
        System.out.printf("t1=%s, %d%n", t3.name(), t3.ordinal());
        System.out.printf("t1=%s, %d%n", t4.name(), t4.ordinal());
        System.out.printf("t1=%s, %d%n", t5.name(), t5.ordinal());

        System.out.println("t1==t2 ? " + (t1==t2));
        System.out.println("t1.compareTo(t3) = " + t1.compareTo(t3));
    }
}
