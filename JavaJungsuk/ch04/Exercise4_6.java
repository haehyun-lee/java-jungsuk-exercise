package ch04;

public class Exercise4_6 {

	public static void main(String[] args) {
		System.out.println("두 눈의 합이 6이 되는 경우");
		for(int i =1; i<=6; i++) {
			for(int j =1; j<=6; j++) {
				if(i+j==6) {
					System.out.printf("[%d, %d] ", i, j);
				}
			}
		}
	}
}
