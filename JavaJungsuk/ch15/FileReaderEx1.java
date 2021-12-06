package ch15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

// FileInputStream & FileReader 차이
public class FileReaderEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "d:/test.txt";
            FileInputStream fis = new FileInputStream(fileName);    // 바이트 기반 스트림
            FileReader fr = new FileReader(fileName);               // 문자 기반 스트림

            int data = 0;
            // FileInputStream 사용
            while ((data = fis.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            fis.close();

            // FileReader 사용
            while ((data = fr.read()) != -1) {
                System.out.print((char)data);
            }
            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
