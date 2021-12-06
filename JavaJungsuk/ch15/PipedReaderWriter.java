package ch15;

import java.io.*;

// PipedReader & PipedWriter : 스레드 간 데이터 교환, Thread
public class PipedReaderWriter {
    public static void main(String[] args) {
        InputThread inThread = new InputThread("InputThread");
        OutputThread outThread = new OutputThread("OutputThread");

        inThread.connect(outThread.getOutput());        // InputThread 에서 OutputThread 에 연결

        inThread.start();
        outThread.start();
    }
}

// 읽기
class InputThread extends Thread {
    PipedReader input = new PipedReader();
    StringWriter sw = new StringWriter();   // String Buffer 사용 용도

    InputThread(String name) {
        super(name);
    }

    public void run() {
        try {
            int data = 0;
            while ((data = input.read()) != -1) {
                sw.write(data);             // 읽어들인 내용 버퍼에 저장해두고
            }
            System.out.println(getName() + " received : " + sw.toString());     //한번에 출력
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedReader getInput() {
        return input;
    }

    public void connect(PipedWriter output) {
        try {
            input.connect(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 쓰기
class OutputThread extends Thread {
    PipedWriter output = new PipedWriter();

    OutputThread(String name) {
        super(name);
    }

    public void run() {
        try {
            String msg = "Hello";
            System.out.println(getName() + " sent : " + msg);
            output.write(msg);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PipedWriter getOutput() {
        return output;
    }

    public void connect(PipedReader input) {
        try {
            output.connect(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}