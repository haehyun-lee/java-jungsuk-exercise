package ch15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// BufferedReader & BufferedWriter : 버퍼를 이용해서 입출력 효율 상승
public class BufferedReaderEx1 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("d:/test.txt");  // 문자 기반 스트림 FileReader
            BufferedReader br = new BufferedReader(fr);             // 문자 기반 보조스트림 BufferedReader

            String line = "";
            for (int i = 1; (line = br.readLine()) != null; i++) {
                // 특정 문자를 포함하는 라인만 출력
                if (line.indexOf(";") != -1) {
                    System.out.println(i + ":" + line);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
