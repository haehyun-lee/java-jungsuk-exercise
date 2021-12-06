package ch15;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 파일 내용 공백 제거
public class FileConversion {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("d:/test.txt");
            FileWriter fw = new FileWriter("d:/test2.txt");

            int data = 0;
            while ((data = fr.read()) != -1) {
                // 공백 문자가 아닐 경우만 출력
                if (data != '\t' && data != '\n' && data != ' ' && data != '\r') {
                    fw.write(data);
                }
            }
            fr.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
