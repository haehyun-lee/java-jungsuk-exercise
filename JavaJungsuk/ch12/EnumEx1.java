package ch12;

enum Direction1 { EAST, SOUTH, WEST, NORTH }

public class EnumEx1 {
    public static void main(String[] args) {
        Direction1 d1 = Direction1.EAST;
        Direction1 d2 = Direction1.valueOf("WEST");
        Direction1 d3 = Enum.valueOf(Direction1.class, "EAST");   // EnumType, Name

        System.out.println("d1=" + d1);
        System.out.println("d2=" + d2);
        System.out.println("d3=" + d3);

        System.out.println("d1==d2 ?" + (d1 == d2));
        System.out.println("d1==d3 ?" + (d1 == d3));
        System.out.println("d1.equals(d3) ? " + (d1.equals(d3)));
//        System.out.println("d2 > d3 ?" + (d1 > d3));
        System.out.println("d1.compareTo(d3) ? " + (d1.compareTo(d3))); // d1이 d3보다 크면 양수, 같으면 0, 작으면 음수 반환
        System.out.println("d1.compareTo(d2) ? " + (d1.compareTo(d2)));

        // switch 문에서 열거형의 이름은 적지 않고 상수 이름만 적는다
        switch (d1) {
            case EAST:
                System.out.println("The direction is EAST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH");
                break;
            case WEST:
                System.out.println("The direction is WEST");
                break;
            case NORTH:
                System.out.println("The direction is NORTH");
                break;
            default:
                System.out.println("Invalid direction.");
                break;
        }

        Direction1[] dArr = Direction1.values();                      // 열거형에 정의된 모든 상수를 배열에 담아 반환

        for (Direction1 d : dArr) {
            System.out.printf("%s=%d%n", d.name(), d.ordinal());    // 열거형 상수의 이름, 열거형 상수가 정의된 순서 반환
        }

    }

}
