package ch7;

public class Exercise7_19 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}
}

class Buyer{
	int money = 1000;					//돈
	Product[] cart = new Product[3];	//장바구니
	int i =0;							//Product배열 인덱스
	
	//지정 상품 구입, 돈 차감, 장바구니 담기
	void buy(Product p) {
		if(money < p.price) {
			System.out.printf("잔액이 부족하여 %s을/를 살수 없습니다.\n", p);
			return;
		}
		
		money -= p.price;
		add(p);
	}
	
	//물건을 장바구니에 담기
	void add(Product p) {
		if(i >= cart.length) {
			Product[] newCart = new Product[cart.length*2];		//장바구니 크기 2배로
			System.arraycopy(cart, 0, newCart, 0, cart.length);	//배열 요소 복사
			cart = newCart;		//장바구니 교체
		}
		
		cart[i] = p;
		i++;
	}
	
	//구입한 물건의 목록과 사용금액, 남은 금액 출력
	void summary() {
		System.out.print("구입한 물건:");
		for(int i=0; i<cart.length; i++) {
			System.out.print(cart[i] + ",");
		}
		System.out.println();
		
		System.out.println("사용한 금액:" + (1000-money));
		System.out.println("사용한 금액:" + money);
	}	
}

class Product{
	int price;
	
	Product(int price){
		this.price = price;
	}
}

class Tv extends Product{
	Tv() { super(100); }
	
	public String toString() { return "Tv"; }
}

class Computer extends Product{
	Computer() { super(200); }
	
	public String toString() { return "Computer"; }
}

class Audio extends Product{
	Audio(){ super(50);}
	
	public String toString() { return "Audio"; }
}
