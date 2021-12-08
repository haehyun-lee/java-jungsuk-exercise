package ch15;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Exercise15_6 {
    static String[] argArr;     // 입력한 매개변수를 담기위한 문자열 배열
    static File curDir;         // 현재 디렉터리

    // static 생성자
    static {
        try{
            curDir = new File(System.getProperty("user.dir"));
        } catch(Exception e){ }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                String promp = curDir.getCanonicalPath() + ">>";
                System.out.print(promp);

                String input = sc.nextLine();

                input = input.trim();
                argArr = input.split(" +");    // argArr[0] = command, argArr[1] = filePath

                String command = argArr[0].trim();
                if("".equals(command)) continue;

                command = command.toLowerCase();

                // 커맨드에 따라 동작 수행
                if (command.equals("q")) {
                    System.exit(0);
                } else if (command.equals("cd")) {
                    cd();
                }else{
                    for (int i = 0; i < argArr.length; i++) {
                        System.out.println(argArr[i]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("입력오류입니다.");
            }
        }
    }

    public static void cd() {
        if (argArr.length == 1) {
            System.out.println(curDir);
        } else if (argArr.length > 2) {
            System.out.println("USAGE : cd directory");
            return;
        }

        String subDir = argArr[1];

        if ("..".equals(subDir)) {
            File newDir = curDir.getParentFile();

            // 현재 디렉토리를 조상 디렉토리로 지정
            if(newDir == null) {
                System.out.println("유효하지 않은 디렉토리입니다.");
            }else {
                curDir = newDir;
            }
        } else if (".".equals(subDir)) {
            System.out.println(curDir);
        }else{
            File newDir = new File(curDir, subDir);     // 현재 디렉토리에 존재하는 파일 인스턴스 생성

            if (newDir.exists() && newDir.isDirectory()) {
                // 현재 디렉토리를 하위 디렉토리로 지정
                curDir = newDir;
            }else{
                System.out.println("유효하지 않은 디렉토리입니다.");
            }
        }
    }
}
