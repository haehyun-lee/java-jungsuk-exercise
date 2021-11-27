package ch05;

public class Exercise5_4 {

	public static void main(String[] args) {
		int[][] arr = {
				{5, 5, 5, 5, 5},
				{10, 10, 10, 10, 10},
				{20, 20, 20, 20, 20},
				{30, 30, 30, 30, 30}
		};
		
		int total = 0;
		float average = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				total += arr[i][j];
				//가변 배열일 때는 여기서 전체 요소 개수 count구해서 평균 산출
			}
		}
		average = (float)total/(arr.length*arr[0].length);
				
		System.out.println("total="+total);
		System.out.println("average="+average);
	}

}
