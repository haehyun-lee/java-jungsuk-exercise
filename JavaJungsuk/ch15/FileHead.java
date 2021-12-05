package ch15;

import java.io.*;
// 파일의 내용을 처음부터 일정 라인만큼 출력
public class FileHead {
    public static void main(String[] args) {
        try {
            int line = Integer.parseInt(args[0]);   //라인 수
            String fileName = args[1];              //파일명
        } catch (Exception e) {

        }
    }
}
