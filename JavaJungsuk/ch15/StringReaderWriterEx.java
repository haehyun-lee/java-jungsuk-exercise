package ch15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

// StringReader & StringWriter
public class StringReaderWriterEx {
    public static void main(String[] args) {
        String inputData = "ABCD";
        StringReader input = new StringReader(inputData);
        StringWriter output = new StringWriter();

        int data = 0;

        try {
            while ((data = input.read()) != -1) {
                output.write(data);                     // StringWriter에 출력된 데이터는 내부의 StringBuffer에 저장됨
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Input Data : " + inputData);
        System.out.println("Output Data : " + output.toString());
        System.out.println("Output Data : " + output.getBuffer().toString());
    }
}
