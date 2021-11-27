package ch09;

public class Exercise9_1 {

	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c1.equals(c2):"+c1.equals(c2));
	}
}

class SutdaCard{
	int num;
	boolean isKwang;
	
	SutdaCard(){
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	//Object클래스의 equals 오버라이딩
	public boolean equals(Object obj) {
		if(obj instanceof SutdaCard) {
			SutdaCard sc = (SutdaCard)obj;
			return this.num==sc.num && this.isKwang == sc.isKwang;
		}
		
		return false;	//return문은 되도록 true-false 하나씩만
	}
	
	//Object클래스의 toString 오버리이딩
	public String toString() {
		return num + (isKwang ? "K":"");
	}
}
