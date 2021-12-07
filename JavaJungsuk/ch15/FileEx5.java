package ch15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

// 현재 디렉터리 내 파일 옵션에 따라 정렬 (최근 수정날짜, 크기, 이름 - 오름차순/내림차순)
public class FileEx5 {
    public static void main(String[] args) {
        if (args.length != 1 || args[0].length() != 1 || "tTlLnN".indexOf(args[0]) == -1) {
            System.out.println("USAGE : java FileEx3 SORT_OPTION");
            System.out.println("    SORT_OPTION : ");
            System.out.println("    t     Time ascending sort.");
            System.out.println("    T     Time descending sort.");
            System.out.println("    l     Length ascending sort");
            System.out.println("    L     Length descending sort");
            System.out.println("    n     Name ascending sort");
            System.out.println("    N     Name descending sort");
            System.exit(0);
        }

        final char option = args[0].charAt(0);

        String currDir = System.getProperty("user.dir");
        File dir = new File(currDir);
        File[] files = dir.listFiles();

        Comparator comp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                File file1 = (File)o1;
                File file2 = (File)o2;

                long time1 = file1.lastModified();
                long time2 = file2.lastModified();

                long length1 = file1.length();
                long length2 = file2.length();

                String name1 = file1.getName().toLowerCase();
                String name2 = file2.getName().toLowerCase();

                int result = 0;

                switch(option) {
                    case 't':
                        if(time1 - time2 > 0) result = 1;
                        else if(time1 - time2 == 0) result = 0;
                        else if(time1 - time2 < 0) result = -1;
                        break;
                    case 'T':
                        if(time1 - time2 > 0) result = -1;
                        else if(time1 - time2 == 0) result = 0;
                        else if(time1 - time2 < 0) result = 1;
                        break;
                    case 'l':
                        if(length1 - length2 > 0) result = 1;
                        else if(length1 - length2 == 0) result = 0;
                        else if(length1 - length2 < 0) result = -1;
                        break;
                    case 'L':
                        if(length1 - length2 > 0) result = -1;
                        else if(length1 - length2 == 0) result = 0;
                        else if(length1 - length2 < 0) result = 1;
                        break;
                    case 'n':
                        result = name1.compareTo(name2);
                        break;
                    case 'N':
                        result = name2.compareTo(name1);
                        break;
                }

                return result;
            }

            public boolean equals(Object o) {
                return false;
            }
        };

        Arrays.sort(files, comp);

        for (File file : files) {
            String name = file.getName();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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

            System.out.printf("%s %3s %6s %s%n", sdf.format(new Date(file.lastModified())), attribute, size, name);
        }
    }
}
