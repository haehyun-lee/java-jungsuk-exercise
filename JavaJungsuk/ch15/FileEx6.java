package ch15;

import java.io.*;

// 지정한 디렉토리와 서브디렉토리에 포함된 확장자가 java, txt, bak 인 모든 파일에서 지정한 키워드가 포함된 라인 출력
public class FileEx6 {
    static int found = 0;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE : java FileEx6 DIRECTORY KEYWORD");
            System.exit(0);
        }

        File dir = new File(args[0]);
        String keyword = args[1];

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        try {
            findInFiles(dir, keyword);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("총 " + found + "개의 라인에서 '" + keyword + "'을/를 발견했습니다.");
    }

    public static void findInFiles(File dir, String keyword) throws IOException {
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                findInFiles(file, keyword);         // 재귀 호출로 디렉토리 내 디렉토리를 탐색
            }else{
                String fileName = file.getName();                                           // 파일명
                String extension = fileName.substring(fileName.lastIndexOf('.') + 1);   // 확장자
                extension = "," + extension + ",";
                if(",java,txt,bak,".indexOf(extension) == -1) {
                    continue;
                }

                fileName = dir.getAbsolutePath() + File.separator + fileName;               // 파일 경로
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String data = "";
                int lineNum = 0;

                while ((data = br.readLine()) != null) {
                    lineNum++;

                    if (data.indexOf(keyword) != -1) {
                        found++;
                        System.out.printf("[%s(%d)] %s%n", fileName, lineNum, data);
                    }
                }
                br.close();
            }
        }
    }
}
