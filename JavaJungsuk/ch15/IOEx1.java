package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

// 바이트 배열에 데이터를 입출력
public class IOEx1 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        // InputStream으로 읽어올 데이터가 존재할 동안 반복
        while ((data = input.read()) != -1) {               // input으로 데이터 읽어서 data에 저장
            output.write(data);                             // output에 data의 데이터 쓰기
            System.out.println("읽어들인 데이터 : " + data);
        }
        
        outSrc = output.toByteArray();

        System.out.println("Input Source : " + Arrays.toString(inSrc));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }
}
