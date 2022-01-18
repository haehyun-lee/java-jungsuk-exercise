package ch13;

public class ThreadEx1 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1(); // A. Thread 상속 클래스 인스턴스
        t1.setName("ExtendsThread");

        Runnable r = new MyThread2();   // B-1. Runnable 구현 클래스 인스턴스
        Thread t2 = new Thread(r, "ImplementThread");      // B-2. Thread(Runnable target) 생성자

        t1.start();
        t2.start();
    }
}

// A. Thread 클래스를 상속받는 방법
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName());  // 상위 클래스의 getName() 메서드 호출
        }
    }
}

// B. Runnable 인터페이스를 구현하는 방법
class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());   // Thread 클래스의 static 메서드 호출
        }
    }
}