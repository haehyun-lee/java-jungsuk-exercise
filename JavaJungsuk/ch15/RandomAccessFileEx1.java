package ch15;

import java.io.*;

// RandomAccessFile : 파일에 대한 입출력 가능
public class RandomAccessFileEx1 {
    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("d:/test4.txt", "rw");
            System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
            raf.writeInt(10);
            System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
            raf.writeLong(100L);
            System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
