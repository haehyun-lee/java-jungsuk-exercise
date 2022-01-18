package ch12;

class DeskTest{
    public static void main(String[] args) {
        Deck d = new Deck();
        Card c = d.pick(0);
        System.out.println(c);

        d.shuffle();
        c = d.pick(0);
        System.out.println(c);
    }
}

class Deck{
    final int CARD_NUM = Card.Kind.values().length * Card.Number.values().length;
    Card[] cardArr = new Card[CARD_NUM];    // 카드 객체 배열

    Deck() {
        int i =0;

        for (Card.Kind kind : Card.Kind.values()) {
            for (Card.Number num : Card.Number.values()) {
                cardArr[i++] = new Card(kind, num);
            }
        }
    }

    Card pick(int index) {
        return cardArr[index];
    }

    Card pick() {
        int index = (int) (Math.random() * CARD_NUM);   // 0~CARD_NUM-1
        return pick(index);
    }

    void shuffle() {
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int) (Math.random() * CARD_NUM);
            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}

class Card{
    enum Kind { CLOVER, HEART, DIAMOND, SPADE }
    enum Number {
        ACE, TWO, THREE, FOUR, FIVE,
        SIX, SEVEN, EHIGHT, NINE, TEN,
        JACK, QUEEN, KING
    }

    Kind kind;
    Number number;

    Card() {
        this(Kind.SPADE, Number.ACE);
    }

    Card(Kind kind, Number num) {
        this.kind = kind;
        this.number = num;
    }

    public String toString() {
        return "[" + kind.name() + ", " + number.name() + "]";
    }
}