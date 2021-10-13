package ch5;

public class Exercise5_5 {

	public static void main(String[] args) {
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];
		
		//배열 ballArr의 임의의 요소를 골라서 위치 바꾸기(셔플)
		for(int i=0; i<ballArr.length; i++) {
			int j = (int)(Math.random() * ballArr.length);	//0~8 사이 난수 생성
			int tmp = 0;
			
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;			
		}
		
		//배열 ballArr의 앞에서 3개의 수를 배열 ball3으로 복사
		System.arraycopy(ballArr, 0, ball3, 0, ball3.length);
		
		for(int i=0; i<ball3.length; i++) {
			System.out.print(ball3[i]);
		}
	}
}
