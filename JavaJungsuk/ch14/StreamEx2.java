package ch14;

import java.io.File;
import java.util.stream.Stream;

// 스트림 타입 변환
public class StreamEx2 {
    public static void main(String[] args) {
        File[] fileArr = {new File("Ex1.java"), new File("Ex2.java"), new File("Ex1.bak"), new File("Ex1"), new File("Ex1.txt")};
        Stream<File> fileStream = Stream.of(fileArr);

        // Stream<File> -> Stream<String>
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);
        
        System.out.println();

        // Stream은 일회용, 한번 사용하면 다시 생성해야 함
        fileStream = Stream.of(fileArr);

        fileStream.map(File::getName)                                   // File -> String
                .filter(s -> s.indexOf('.') != -1)
                .peek(s -> System.out.printf("filename=%s%n", s))
                .map(s -> s.substring(s.lastIndexOf('.') + 1))
                .peek(s -> System.out.printf("extension=%s%n", s))
                .map(String::toUpperCase)
                .peek(s -> System.out.printf("uppercase=%s%n", s))
                .distinct()
                .forEach(System.out::println);

        System.out.println();
    }
}
