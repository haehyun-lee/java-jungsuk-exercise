package ch15;

import java.io.Serializable;

// 직렬화가 가능한 클래스
public class UserInfo implements Serializable {
    String name;
    String password;
    int age;

    public UserInfo() {
        this("Unkown", "1111", 0);
    }

    public UserInfo(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String toString() {
        return "(" + name + ", " + password + ", " + age + ")";
    }
}
