package ch12;

import java.util.ArrayList;

class Fruit1 { public String toString() { return "Fruit"; } }
class Apple1 extends Fruit1 { public String toString() { return "Apple"; } }
class Grape1 extends Fruit1 { public String toString() {return "Grape"; } }
class Toy1 { public String toString() {return "Toy"; } }

public class FruitBoxEx1 {
    public static void main(String[] args) {
        Box1<Fruit1> fruitBox = new Box1<Fruit1>();
        Box1<Apple1> appleBox = new Box1<Apple1>();
        Box1<Toy1> toyBox = new Box1<Toy1>();
//        Box<Grape> grapeBox = new Box<Apple>();   // 참조변수와 생성자에 대입된 타입이 일치해야 함

        fruitBox.add(new Fruit1());
        fruitBox.add(new Apple1());                  // 타입변수의 자손들은 T 타입 리스트에 추가 가능
//        fruitBox.add(new Toy());

        appleBox.add(new Apple1());
        appleBox.add(new Apple1());

        toyBox.add(new Toy1());
//        toyBox.add(new Apple());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(toyBox);
    }
}

class Box1<T>{
    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i)     { return list.get(i); }
    int size()       { return list.size(); }
    public String toString() { return list.toString(); }
}
