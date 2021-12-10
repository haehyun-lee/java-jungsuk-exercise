package ch12;

// 열거형도 하나의 타입(인스턴스)라고 생각, 하나의 열거형 인스턴스는 하나의 상수값만으로 지정됨
enum Direction{
    // 열거형 사용자 값 지정
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");

    private static final Direction[] DIR_ARR = Direction.values();
    private final int value;
    private final String symbol;

    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() { return value; }
    public String getSymbol() { return symbol; }

    public static Direction of(int dir) {
        if (dir < 1 || dir > 4) {
            throw new IllegalArgumentException("Invalid value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    // 방향 회전, num의 값만큼 90도씩 시계방향으로 회전
    public Direction rotate(int num) {
        num = num % 4;              // 90 * 3 = 360도 회전하면 원위치, 즉 0~3번 회전만 존재

        if(num < 0) num += 4;       // 음수일 경우 시계반대 방향으로 회전, -1 == +3, -2 == +2

        return DIR_ARR[(value - 1 + num) % 4];      // num을 더한 값이 3을 넘어갈 경우를 대비
    }

    public String toString() {
        return name() + getSymbol();
    }
}

public class EnumEx2 {
    public static void main(String[] args) {
        for (Direction d : Direction.values()) {
            System.out.printf("%s=%d%n", d.name(), d.getValue());
        }

        Direction d1 = Direction.EAST;      // EAST
        Direction d2 = Direction.of(1);     // EAST

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());

        System.out.println(Direction.EAST.rotate(1));
        System.out.println(Direction.EAST.rotate(2));
        System.out.println(Direction.EAST.rotate(-1));  // rotate(3)
        System.out.println(Direction.EAST.rotate(-2));  // rotate(2)
    }
}