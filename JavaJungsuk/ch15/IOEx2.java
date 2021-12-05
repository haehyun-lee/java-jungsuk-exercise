package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

// 바이트 배열에 데이터를 입출력
public class IOEx2 {
    public static void main(String[] args) {
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        input.read(temp, 0, temp.length);       // 최대 temp.length개의 byte를 읽어서, temp배열의 0위치 부터 저장 (input -> temp)
        output.write(temp, 5, 5);           // temp배열에 저장된 내용 중에서 5번째 부터 5만을 읽어서 출력소스에 쓰기 (temp -> output)
        
        outSrc = output.toByteArray();

        System.out.println("Input Source  : " + Arrays.toString(inSrc));
        System.out.println("temp          : " + Arrays.toString(temp));
        System.out.println("Output Source : " + Arrays.toString(outSrc));

    }
}
