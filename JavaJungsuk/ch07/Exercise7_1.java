package ch07;


class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		for (int i = 0; i < cards.length; i++) {
			int num = i % 10 + 1;
			boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);

			cards[i] = new SutdaCard(num, isKwang);
		}
	}
	
	//배열 cards에 담긴 카드의 위치를 뒤섞음
	public void shuffle() {
		for(int i=0; i<cards.length; i++) {
			int index = (int)(Math.random()*cards.length);
			
			SutdaCard tmp = cards[i];
			cards[i] = cards[index];
			cards[index] = tmp;
		}
	}
	
	//배열 cards에서 지정된 위치의 SutdaCard를 반환
	public SutdaCard pick(int index) {
		return cards[index];
	}
	
	//배열 cards에서 임의의 위치의 SutdaCard를 반환
	public SutdaCard pick() {
		int index = (int)(Math.random()*cards.length);
		return cards[index];
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// Object클래스의 toString() 오버라이딩
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Exercise7_1 {

	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for(int i=0; i<deck.cards.length; i++) {
			System.out.print(deck.cards[i]+", ");
		}
		
		System.out.println();
		System.out.println(deck.pick(0));
	}
}
