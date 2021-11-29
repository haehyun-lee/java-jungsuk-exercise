package ch11;

import java.util.HashMap;

// HashMap 활용, 카드게임
public class Exercise11_12 {
    public static void main(String[] args) throws Exception {
        SutdaDeck2 deck = new SutdaDeck2();                                  // 카드 덱 구성

        deck.shuffle();                                                     // 카드 섞기
        Player2 p1 = new Player2("타짜", deck.pick(), deck.pick());     // 카드 뽑기
        Player2 p2 = new Player2("고수", deck.pick(), deck.pick());
        
        System.out.println(p1 + " " + deck.getPoint(p1));
        System.out.println(p2 + " " + deck.getPoint(p2));
    }
}

class SutdaDeck2 {
    final int CARD_NUM = 20;
    SutdaCard2[] cards = new SutdaCard2[CARD_NUM];

    int pos = 0;    // 다음에 가져올 카드의 위치 (카드를 순서대로 쌓여있으니까)
    HashMap jokbo = new HashMap();      // 족보를 저장할 HashMap
    
    // 카드 덱 세팅
    SutdaDeck2() {
        // SutdaCard 범위 : 1~10, K
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);

            cards[i] = new SutdaCard2(num, isKwang);
        }

        registerJokbo();
    }
    
    // HashMap에 등급과 점수를 저장
    void registerJokbo() {
        jokbo.put("KK", 4000);
        for (int i = 1; i <= 10; i++) {
            jokbo.put(String.format("%d%d", i, i), i * 10 + 3000);
        }

        jokbo.put("12", 2060);
        jokbo.put("21", 2060);
        jokbo.put("14", 2050);
        jokbo.put("41", 2050);
        jokbo.put("19", 2040);
        jokbo.put("91", 2040);
        jokbo.put("110", 2030);
        jokbo.put("101", 2030);
        jokbo.put("410", 2020);
        jokbo.put("104", 2020);
        jokbo.put("46", 2010);
        jokbo.put("64", 2010);
    }

    // 게임참가자의 점수를 계산해서 반환
    int getPoint(Player2 p) {
        // 족보상 높은 등급의 카드가 이긴다. 이기면 점수 추가
        if(p==null) return 0;

        SutdaCard2 c1 = p.c1;
        SutdaCard2 c2 = p.c2;

        Integer result = 0;

        if (c1.isKwang && c2.isKwang) {
            result = (Integer)jokbo.get("KK");
        }else {
            String key = String.format("%d%d", c1.num, c2.num);
            if (jokbo.containsKey(key)) {
                result = (Integer) jokbo.get(key);
            }else{
                result = (c1.num + c2.num) % 10 + 1000;
            }
        }

        return result.intValue();
    }

    // 카드 뽑기
    SutdaCard2 pick() throws Exception {
        SutdaCard2 c = null;

        if (0 <= pos && pos < CARD_NUM) {
            c = cards[pos];
            cards[pos++] = null;            // 뽑은 카드는 빼기
        }else{
            throw new Exception("남아있는 카드가 없습니다.");
        }

        return c;
    }
    
    // 카드 섞기
    void shuffle() {
        for (int x = 0; x < CARD_NUM * 2; x++) {
            int i = (int)(Math.random() * CARD_NUM);
            int j = (int)(Math.random() * CARD_NUM);

            SutdaCard2 tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }
}

class Player2 {
    String name;
    SutdaCard2 c1;
    SutdaCard2 c2;

    int point;      // 카드 등급에 따른 점수

    Player2(String name, SutdaCard2 c1, SutdaCard2 c2) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
    }

    public String toString() {
        return "[" + name + "]" + c1.toString() + ", " + c2.toString();
    }
}

class SutdaCard2 {
    int num;
    boolean isKwang;

    SutdaCard2() {
        this(1, true);
    }

    SutdaCard2(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}