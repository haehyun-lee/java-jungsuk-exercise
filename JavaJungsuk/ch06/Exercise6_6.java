package ch06;

public class Exercise6_6 {
	//두 점(x, y)와 (x1, y1)간의 거리를 구한다.
	static double getDistance(int x, int y, int x1, int y1) {
		//Math.pow(a, b) : 제곱 ,  Math.sqrt(a) : 루트
		return Math.sqrt(Math.pow(x1-x, 2) + Math.pow(y1-y, 2));
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1, 1, 2, 2));
	}
}
 