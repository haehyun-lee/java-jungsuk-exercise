package ch15;

import java.io.*;

public class FileEx7 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java FileEx7 pattern");
            System.exit(0);
        }

        String currDir = System.getProperty("user.dir");    // 현재 디렉터리
        File dir = new File(currDir);

        final String pattern = args[0];                     // 패턴

        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.indexOf(pattern) != -1;
            }
        });

        for (String fileName : files) {
            System.out.println(fileName);
        }
    }
}
