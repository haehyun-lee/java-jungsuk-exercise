package ch15;

import java.io.*;

// 파일에 있는 태그를 모두 제거
public class Exercise15_5 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("USAGE : java Exercise15_5 TARGET_FILE RESULT_FILE");
            System.exit(0);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try {
            // 문자 인코딩 설정
            InputStreamReader isr = new InputStreamReader(new FileInputStream(inputFile), "utf-8");
            BufferedReader input = new BufferedReader(isr);

            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outputFile), "utf-8");
            HtmlTagFilterWriter output = new HtmlTagFilterWriter(osw);

            int ch = 0;

            while ((ch = input.read()) != -1) {
                output.write(ch);
            }

            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 사용자 지정 보조 스트림
class HtmlTagFilterWriter extends FilterWriter {
    StringWriter tmp = new StringWriter();
    boolean inTag = false;

    HtmlTagFilterWriter(Writer out) {
        super(out);
    }

    public void write(int c) throws IOException {
        if (c == '<') {
            inTag = true;
        } else if (c == '>' && inTag) {
            inTag = false;
            tmp = new StringWriter();       // 지금까지의 내용을 버림
        }

        if (inTag) {
            tmp.write(c);   // 누락 문자
        }else{
            out.write(c);   // 실제 출력 문자
        }
    }

    public void close() throws IOException {
        out.write(tmp.toString());          // StringWriter의 내용 출력 (실제로 출력되지 않은 태그 내용들)
        super.close();                      // 조상 close() 호출 기반스트림 닫기
    }
}
