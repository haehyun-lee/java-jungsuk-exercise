package ch15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

// System.out의 출력대상을 파일로 변경 (에러 로그 기록용)
public class StandardIOEx3 {
    public static void main(String[] args) {
        PrintStream ps = null;          // 바이트기반 보조 스트림 PrintStream
        FileOutputStream fos = null;    // 바이트기반 스트림 FileOutputStream

        try {
            fos = new FileOutputStream("d:/test3.txt");
            ps = new PrintStream(fos);
            System.setOut(ps);          // System.out은 PrintStream
        } catch (IOException e) {
            System.err.println("File not found.");
        }

        System.out.println("Hello by System.out");
        System.out.println("Hello by System.err");
    }
}
