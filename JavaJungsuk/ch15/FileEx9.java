package ch15;

import java.io.File;

// 파일명 일괄 변경
public class FileEx9 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java FileEx9 Directory");
            System.exit(0);
        }

        File dir = new File(args[0]);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉터리입니다.");
            System.exit(0);
        }

        File[] files = dir.listFiles();
        
        for (File file : files) {
            String fileName = file.getName();
            String newFileName = "0000" + fileName;                             // 파일명 앞에 000추가
            System.out.print(newFileName);
            newFileName = newFileName.substring(newFileName.length() - 7);      // 파일명 길이 맞추기
            System.out.print(" → " + newFileName);
            boolean succeed = file.renameTo(new File(dir, newFileName));        // 경로 내 같은 파일명이 존재할 경우 변경 X
            System.out.println(succeed ? " : 변경 성공" : " 변경 실패");
        }
    }
}
