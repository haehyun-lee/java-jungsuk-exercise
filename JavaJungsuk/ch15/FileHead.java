package ch15;

import java.io.*;
// 파일의 내용을 처음부터 일정 라인만큼 출력
public class FileHead {
    public static void main(String[] args) {
        try {
            int lineNum = Integer.parseInt(args[0]);    //라인 수
            String fileName = args[1];                  //파일명

            File f = new File(fileName);

            // 파일이 존재하고 디렉토리가 아닐 경우
            if (f.exists() && !f.isDirectory()) {
                // 문자기반 스트림 FileReader, 문자기반 보조스트림 BufferedReader
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                
                String line = "";
                int i = 1;

                // 출력하려는 라인 수보다 내용이 적을 경우 고려
                while ((line = br.readLine()) != null && i <= lineNum) {
                    System.out.println(i + ":" + line);
                    i++;
                }
            }else{
                throw new FileNotFoundException(fileName + "은/는 디렉토리이거나, 존재하지 않는 파일입니다.");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("USAGE: java fileHead 10 FILENAME");
        }
    }
}
