package ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

// 역직렬화 (스트림 -> 객체 입력)
public class SerialEx2 {
    public static void main(String[] args) {
        try {
            String fileName = "UserInfo.ser";
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            ObjectInputStream input = new ObjectInputStream(bis);

            // 객체를 읽을 때는 출력한 순서와 일치해야 함
            UserInfo2 u1 = (UserInfo2) input.readObject();        // readObject() 반환 값은 Object이기 때문에 형변화 필수
            UserInfo2 u2 = (UserInfo2) input.readObject();
            ArrayList<UserInfo2> list = (ArrayList<UserInfo2>) input.readObject();

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
