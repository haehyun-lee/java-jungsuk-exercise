package ch15;

import java.io.File;

// 지정한 확장자의 파일을 삭제
public class FileEx8 {
    static int deletedFiles = 0;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE : java FileEx8 Directory Extension");
            System.exit(0);
        }

        File dir = new File(args[0]);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉터리입니다.");
            System.exit(0);
        }

        String ext = "." + args[1];         // 확장자이기 때문에 .ext

        delete(dir, ext);
        System.out.println(deletedFiles + "개의 파일이 삭제되었습니다.");
    }

    public static void delete(File dir, String ext) {
        File[] files = dir.listFiles();

        for (File file : files) {
            // 파일이 디렉터리일 경우 재귀 호출
            if (file.isDirectory()) {
                delete(file, ext);
            }else{
                String fileName = file.getAbsolutePath();
                // 특정 확장자 파일만 삭제
                if (fileName.endsWith(ext)) {
                    System.out.print(fileName);
                    // 삭제 성공 여부 출력
                    if (file.delete()) {
                        System.out.println(" - 삭제 성공");
                        deletedFiles++;
                    }else{
                        System.out.println(" - 삭제 실패");
                    }
                }
            }
        }
    }
}
