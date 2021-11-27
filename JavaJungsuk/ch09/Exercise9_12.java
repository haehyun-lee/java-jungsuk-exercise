package ch09;

public class Exercise9_12 {
	/**
	 * 주어진 범위에 속한 임의의 정수값을 반환 (양쪽 경계값 모두 범위에 포함)
	 * @param from	범위의 시작값
	 * @param to	범위의 끝값
	 * @return		범위 내 정수값
	 */
	public static int getRand(int from, int to) {
		//시작값이 끝값 보다 클 경우 값 전환
		if(from > to) {
			int tmp = from;
			from = to;
			to = tmp;
		}
		
		//Math.random()*범위맞추기+시작값맞추기
		return (int)(Math.random()*(Math.abs(to-from)+1))+Math.min(from, to);	//(int) 캐스팅 대상 괄호 위치 주의
	}
	
	public static void main(String[] args) {
		for(int i=0; i<20; i++) {
			System.out.print(getRand(1, -3)+", ");
		}
	}
}
