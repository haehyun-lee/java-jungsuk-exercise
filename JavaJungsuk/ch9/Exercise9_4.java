package ch9;

public class Exercise9_4 {
	//주어진 배열에 담긴 값만큼 주어진 문자를 가로로 출력한 후, 값을 출력
	static void printGraph(int[] dataArr, char ch) {
		for(int i=0; i<dataArr.length; i++) {
			for(int j=0; j<dataArr[i]; j++) {
				System.out.print("*");
			}
			System.out.println(dataArr[i]);
		}
	}
	
	public static void main(String[] args) {
		printGraph(new int[] {3, 7, 1, 4}, '*');
	}
}