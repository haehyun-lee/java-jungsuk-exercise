package ch09;

public class Exercise9_8 {
	//주어진 값을 반올림하여, 소수점 이하 n자리의 값을 반환
	public static double round(double d, int n) {
		return (double)(Math.round(d * Math.pow(10, n))) / Math.pow(10, n);
	}

	public static void main(String[] args) {
		System.out.println(round(3.1415, 1));
		System.out.println(round(3.1415, 2));
		System.out.println(round(3.1415, 3));
		System.out.println(round(3.1415, 4));
		System.out.println(round(3.1415, 5));
	}

}
