package ch11;

import java.util.HashSet;
import java.util.Objects;

// 같은 객체 판별 여부
class SutdaCard1 {
    int num;
    boolean isKwang;

    SutdaCard1(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    SutdaCard1() {
        this(1, true);
    }

    // equals() 오버라이딩
    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard1) {
            SutdaCard1 c = (SutdaCard1) obj;
            return num == c.num && isKwang == c.isKwang;
        } else {
            return false;
        }
    }

    // hashCode() 오버라이딩 = equals()가 true면 무조건 같은 값 반환.
    public int hashCode() {
        return Objects.hash(num, isKwang);
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise11_11 {
    public static void main(String[] args) {
        SutdaCard1 c1 = new SutdaCard1(3, true);
        SutdaCard1 c2 = new SutdaCard1(3, true);
        SutdaCard1 c3 = new SutdaCard1(1, true);

        // HashSet은 중복X, 기존에 저장된 요소와 같은 것인지 판별하기 위해 추가하려는 요소의 equals(), hashCode()를 호출
        HashSet<SutdaCard1> set = new HashSet<>();
        set.add(c1);
        set.add(c2);
        set.add(c3);

        System.out.println(set);
    }
}
