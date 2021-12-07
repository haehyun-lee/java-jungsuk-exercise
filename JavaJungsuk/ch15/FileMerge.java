package ch15;

import java.io.*;

// 분할된 파일을 하나로 합치기
public class FileMerge {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE : java FileMerge filepath");
            System.exit(0);
        }

        String mergeFileName = args[0];

        try {
            File tempFile = File.createTempFile("~mergetemp", ".tmp");  // 임시 파일을 시스템의 임시 디렉토리에 생성
            tempFile.deleteOnExit();                                                // 프로그램 종료 시 파일 삭제

            FileOutputStream fos = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            BufferedInputStream bis = null;

            int number = 1;

            File f = new File(mergeFileName + "_." + number);              // FileSplit 에서 분할된 파일들

            while (f.exists()) {
                f.setReadOnly();                                                    // 작업 중 파일 내용 변경 막기
                bis = new BufferedInputStream(new FileInputStream(f));              // 분할 파일들 읽어서

                int data = 0;
                while ((data = bis.read()) != -1) {
                    bos.write(data);
                }
                
                bis.close();

                f = new File(mergeFileName + "_." + ++number);              // 다음 읽을 파일 준비
            }
            
            bos.close();

            File oldFile = new File(mergeFileName);
            if (oldFile.exists()) {
                oldFile.delete();
            }
            tempFile.renameTo(oldFile);                                              // 내용이 통합된 임시파일을 본파일로 대체
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
