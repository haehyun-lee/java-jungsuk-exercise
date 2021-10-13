package ch6;

public class Exercise6_20 {
	static int[] shuffle(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int rand = (int)(Math.random()*arr.length);	//(int)에 바로 Math.random()값이 형변환되지 않게 주의
			
			int tmp = arr[i];
			arr[i] = arr[rand];
			arr[rand] = tmp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
