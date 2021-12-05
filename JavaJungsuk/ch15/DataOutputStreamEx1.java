package ch15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx1 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fos = new FileOutputStream("sample.dat");
            dos = new DataOutputStream(fos);        // OutputStream 을 기반스트림으로 하는 DataOutputStream 생성
            dos.writeInt(10);
            dos.writeFloat(20.0f);
            dos.writeBoolean(true);
            
            dos.close();        // 보조스트림 닫으면 기반 클래스도 닫힘
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
