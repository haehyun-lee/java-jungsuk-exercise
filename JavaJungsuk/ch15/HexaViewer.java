package ch15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

// 이진파일을 읽어서 정해진 포맷의 16진수로 출력
public class HexaViewer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java HexaViewer FILENAME");
            System.exit(0);
        }

        String fileName = args[0];      // 이진파일

        try {
            FileInputStream input = new FileInputStream(fileName);  // 파일 읽기
            PrintStream output = new PrintStream(System.out);       // 데이터를 기반 스트림에 다양한 형태로 출력

            int data = 0;
            int i = 0;
            while ((data = input.read()) != -1) {
                output.printf("%02X", data);        // String Formatting
                if (++i % 16 == 0) {
                    output.println();
                }
            }

            input.close();
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
