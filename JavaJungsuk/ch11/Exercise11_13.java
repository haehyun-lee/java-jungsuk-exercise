package ch11;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// TreeMap 활용(정렬, 순위), 카드게임
public class Exercise11_13 {
    public static void main(String[] args) throws Exception {
        SutdaDeck deck = new SutdaDeck();
        
        deck.shuffle();
        
        Player[] pArr = {
                new Player("타짜", deck.pick(), deck.pick()),
                new Player("고수", deck.pick(), deck.pick()),
                new Player("물주", deck.pick(), deck.pick()),
                new Player("중수", deck.pick(), deck.pick()),
                new Player("하수", deck.pick(), deck.pick()),
        };
        
        TreeMap rank = new TreeMap(new Comparator(){
            // 점수 내림차순
            public int compare(Object o1, Object o2) {
                // TreeSet에 들어오는 객체를 대상으로 비교하는 것이기 때문에 Player, 만약 TreeSet 값 추가 후 Collections.sort()로 정렬할 경우네는 instanceof Map.Entry
                if (o1 instanceof Player && o2 instanceof Player) {
                    Player p1 = (Player)o1;
                    Player p2 = (Player)o2;

                    return p2.point - p1.point;
                }else{
                    return -1;
                }
            }
        });

        for (int i = 0; i < pArr.length; i++) {
            Player p = pArr[i];
            rank.put(p, deck.getPoint(p));                  //deck.getPoint()에서 p.point 값도 설정됨
            System.out.println(p + " " + deck.getPoint(p));
        }

        System.out.println();
        System.out.println("1위는 " + rank.firstKey() + "입니다. ");

    }
}

class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    int pos = 0;    // 다음에 가져올 카드의 위치 (카드를 순서대로 쌓여있으니까)
    HashMap jokbo = new HashMap();      // 족보를 저장할 HashMap
    
    // 카드 덱 세팅
    SutdaDeck() {
        // SutdaCard 범위 : 1~10, K
        for (int i = 0; i < cards.length; i++) {
            int num = i % 10 + 1;
            boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);

            cards[i] = new SutdaCard(num, isKwang);
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
    int getPoint(Player p) {
        // 족보상 높은 등급의 카드가 이긴다. 이기면 점수 추가
        if(p==null) return 0;

        SutdaCard c1 = p.c1;
        SutdaCard c2 = p.c2;

        Integer result = 0;

        if (c1.isKwang && c2.isKwang) {
            result = (Integer)jokbo.get("KK");
        }else {
            result = (Integer) jokbo.get("" + c1.num + c2.num);

            if (result == null) {
                result = (c1.num + c2.num) % 10 + 1000;
            }
        }

        p.point = result.intValue();

        return result.intValue();
    }

    // 카드 뽑기
    SutdaCard pick() throws Exception {
        SutdaCard c = null;

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

            SutdaCard tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
    }
}

class Player {
    String name;
    SutdaCard c1;
    SutdaCard c2;

    int point;      // 카드 등급에 따른 점수

    Player(String name, SutdaCard c1, SutdaCard c2) {
        this.name = name;
        this.c1 = c1;
        this.c2 = c2;
    }

    public String toString() {
        return "[" + name + "]" + c1.toString() + ", " + c2.toString();
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

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}