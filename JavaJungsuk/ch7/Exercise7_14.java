package ch7;

class SutdaCard2 {
	final int NUM;			//상수는 대문자로, 공백은 (_)로
	final boolean IS_KWANG;
	
	SutdaCard2(){
		this(1, true);
	}
	
	SutdaCard2(int num, boolean isKwang){
		this.NUM = num;
		this.IS_KWANG = isKwang;		//인스턴스 변수의 경우, 생성자에서 상수 초기화 가능
	}
	
	public String toString() {
		return NUM + (IS_KWANG ? "K":"");
	}
}

public class Exercise7_14 {

	public static void main(String[] args) {
		SutdaCard2 card = new SutdaCard2(1, true);
	}
}
