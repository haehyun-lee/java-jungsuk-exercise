package ch15;

import java.io.*;

public class RandomAccessFileEx2 {
    public static void main(String[] args) {
        int[] score = { 1, 100, 90, 90,
                        2, 70, 90, 100,
                        3, 100, 100, 100,
                        4, 70, 60, 80,
                        5, 70, 90, 100 };

        try {
            RandomAccessFile raf = new RandomAccessFile("d:/test4.dat", "rw");
            for (int i = 0; i < score.length; i++) {
                raf.writeInt(score[i]);                 // int 값을 입력할 때 마다 포인터가 다음 입력자리(마지막)로 이동됨
            }

            raf.seek(0);                           // 값을 읽기 위해 포인터를 처음으로 이동
            while (true) {
                System.out.println(raf.readInt());
            }
        } catch (EOFException e){
            // 무한반복 종료
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
