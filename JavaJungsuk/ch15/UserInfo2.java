package ch15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class SuperUserInfo{
    String name;
    String password;

    SuperUserInfo() {
        this("Unknown", "1111");
    }

    SuperUserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }
}

public class UserInfo2 extends SuperUserInfo implements java.io.Serializable {
    int age;

    public UserInfo2() {
        this("Unknown", "1111", 0);
    }

    public UserInfo2(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    public String toString() {
        return "(" + name + ", " + password + ", " + age + ")";
    }

    // 부모 클래스가 직렬화(Serializable) 되지 않기 때문에 부모 인스턴스변수들이 직렬화되도록 처리하는 코드를 직접 구현

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(password);
        out.defaultWriteObject();       // 클래스 자신에 정의된 인스턴스변수 자동 직렬화
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        password = in.readUTF();
        in.defaultReadObject();         // 클래스 자신에 정의된 인스턴스변수 자동 역직렬화
    }
}
