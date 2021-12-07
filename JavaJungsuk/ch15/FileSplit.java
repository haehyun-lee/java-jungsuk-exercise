package ch15;

import java.io.*;

// 하나의 파일을 지정 크키별로 분할
public class FileSplit {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("USAGE : java FileSplit filepath SIZE_KB");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("유효하지 않은 파일입니다.");
            System.exit(0);
        }

        final int VOLUME = Integer.parseInt(args[1]) * 1000;        // 1KB = 1000Byte

        try {
            String fileName = file.getName();
            
            FileInputStream fis = new FileInputStream(file);                    // 파일 읽기
            BufferedInputStream bis = new BufferedInputStream(fis);             // 파일 내용 읽기

            FileOutputStream fos = null;
            BufferedOutputStream bos = null;

            int data = 0;
            int i = 0;
            int number = 0;

            while ((data = bis.read()) != -1) {
                if (i % VOLUME == 0) {
                    if (i != 0) {
                        bos.close();
                    }

                    fos = new FileOutputStream(fileName + "_." + ++number);  // 파일 출력
                    bos = new BufferedOutputStream(fos);
                }
                bos.write(data);                                                  // 파일 내용 쓰기
                i++;
            }

            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
