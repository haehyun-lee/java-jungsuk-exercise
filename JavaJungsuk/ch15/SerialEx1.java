package ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// 직렬화 (객체 -> 스트림 출력)
public class SerialEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "UserInfo.ser";
            FileOutputStream fos = new FileOutputStream(fileName);          // 기반스트림
            BufferedOutputStream bos = new BufferedOutputStream(fos);       // 보조스트림

            ObjectOutputStream out = new ObjectOutputStream(bos);           // 보조스트림 : 객체 직렬화 (객체 -> 스트림)

            // 객체 생성
            UserInfo2 u1 = new UserInfo2("JavaMan", "1234", 25);
            UserInfo2 u2 = new UserInfo2("JavaWoman", "4321", 30);

            ArrayList<UserInfo2> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            // 객체 직렬화
            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);

            out.close();
            System.out.println("직렬화 정상 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
