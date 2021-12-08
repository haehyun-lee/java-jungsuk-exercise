package ch15;

import java.io.*;
import java.util.Vector;

// 여러 파일을 하나로 연결
public class FileMergeTest {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("USAGE : java FileMergeTest MERGE_FILENAME FILENAME1 FILENAME2 ...");
            System.exit(0);
        }

        try {
            Vector v = new Vector();     // 입력스트림 저장용 Enumeration

            for (int i = 1; i < args.length; i++) {
                File f = new File(args[i]);

                if (f.exists()) {
                    v.add(new FileInputStream(args[i]));
                }else{
                    System.out.println(args[i] + " - 존재하지 않는 파일입니다.");
                    System.exit(0);
                }
            }

            SequenceInputStream input = new SequenceInputStream(v.elements());  // 여러 입력 스트림을 하나로 연결
            FileOutputStream output = new FileOutputStream(args[0]);

            int data = 0;

            while ((data = input.read()) != -1) {
                output.write(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
