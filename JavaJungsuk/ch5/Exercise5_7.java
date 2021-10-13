package ch5;

public class Exercise5_7 {

	public static void main(String[] args) {
		//커맨드라인으로 전달받은 인자 체크
		if(args.length != 1) {
			System.out.println("USAGE: java Exercise5_7 3120");
			System.exit(0);
		}
		
		//문자열을 숫자로 변환 (커맨드로 받은 인자는 무조건 문자열)
		int money = Integer.parseInt(args[0]);
				
		System.out.println("money="+money);
		
		int[] coinUnit = {500, 100, 50, 10};	//동전의 단위
		int[] coin = {5, 5, 5, 5};				//단위별 동전의 개수
		
		for(int i=0; i<coinUnit.length; i++) {
			int coinNum = 0;
			
			coinNum = money/coinUnit[i];		//필요한 동전개수
			if(coinNum>coin[i]) {
				coinNum = coin[i];				//동전 부족, 있는 만큼만 사용
			}
						
			coin[i] -= coinNum;					//동전개수 차감
			money -= (coinUnit[i]*coinNum);		//전체 값에서 동전단위*돈전개수 만큼 빼기

			System.out.println(coinUnit[i]+"원: "+coinNum);
		}
		
		//전체 값이 아직 남아있으면, 거스름돈이 부족해 덜 거슬러준 것
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0);
		}
		
		System.out.println("=남은 동전의 개수=");
		
		for(int i=0; i<coinUnit.length; i++) {
			System.out.println(coinUnit[i]+"원:"+coin[i]);
		}
	}
}
