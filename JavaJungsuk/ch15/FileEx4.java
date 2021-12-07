package ch15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

// 현재 디렉토리에 속한 파일과 디렉토리 정보
public class FileEx4 {
    public static void main(String[] args) {
        String currDir = System.getProperty("user.dir");
        File dir = new File(currDir);

        File[] files = dir.listFiles();

        for (File file : files) {
            String fileName = file.getName();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mma");
            String attribute = "";
            String size = "";

            if (file.isDirectory()) {
                attribute = "DIR";
            } else {
                size = String.valueOf(file.length());
                attribute = file.canRead() ? "R" : " ";
                attribute += file.canWrite() ? "W" : " ";
                attribute += file.canExecute() ? "E" : " ";
            }

            System.out.printf("%s %3s %6s %s%n", sdf.format(new Date(file.lastModified())), attribute, size, fileName);
        }
    }
}
