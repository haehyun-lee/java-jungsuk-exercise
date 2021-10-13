package ch4;

public class Exercise4_8 {

	public static void main(String[] args) {
		for(int x = 0; x<=10; x++) {
			for(int y=0; y<=10; y++) {
				//방정식에 부합하는 x, y만 출력
				if((2*x + 4*y) == 10) {
					System.out.printf("x=%d, y=%d\n", x, y);
				}
			}
		}
	}
}
