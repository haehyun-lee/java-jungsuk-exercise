package ch7;

abstract class Unit{
	int x, y;
	abstract void move(int x, int y);	//추상클래스, only 메서드 선언부
	void stop() {}	
}

class Marine extends Unit{
	void move(int x, int y) {}		//메서드 구현은 자손클래스에서
	void stimPack() {}
}

class Tank extends Unit{
	void move(int x, int y) {}
	void changeMode() {}
}

class Dropship extends Unit{
	void move(int x, int y) {}
	void load() {}
	void unload() {}
}

public class Exercise7_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
