package ch12;

enum Transportation{
    // 열거형 상수 내에서 추상메서드 구현
    BUS(100) { int fare(int distance) { return distance * BASIC_FARE; }},
    TRAIN(150) { int fare(int distance) { return distance * BASIC_FARE; }},
    SHIP(100) { int fare(int distance) { return distance * BASIC_FARE; }},
    AIRPLANE(300) { int fare(int distance) {return distance * BASIC_FARE; }};


    protected final int BASIC_FARE;         // 각 상수에서 접근 가능하게 protected

    Transportation(int basicFare) {
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() { return BASIC_FARE; }

    abstract int fare(int distance);        // 거리에 따른 요금 계산 추상메서드
}

public class EnumEx3 {
    public static void main(String[] args) {
        // 교통수단 별 요금 = 기본 요금 * 거리
        System.out.println("bus fare = " + Transportation.BUS.fare(100));
        System.out.println("train fare = " + Transportation.TRAIN.fare(100));
        System.out.println("ship fare = " + Transportation.SHIP.fare(100));
        System.out.println("airplane fare = " + Transportation.AIRPLANE.fare(100));
    }
}
