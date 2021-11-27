package ch07;

import java.awt.*;
import java.awt.event.*;

public class Exercise7_28 {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);	//Window 인스턴스 내 메서드
				e.getWindow().dispose();
				System.exit(0);
			}
		});
	}
}

/*
 * 기존에는 EventHandler라는 클래스를 별도로 만들고 WindowAdapter인터페이스를 구현하는 방식이었지만
 * 익명메서드는 말그대로 클래스명이 없고, 1회용 클래스. new 클래스명 대신, new 조상클래스/인터페이스명으로 바로 선언
 * 익명클래스를 매개변수로 받는 곳의 반환값과 일치되는 타입
 */