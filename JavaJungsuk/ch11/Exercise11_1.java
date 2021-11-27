package ch11;

import java.util.ArrayList;

public class Exercise11_1 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);

		ArrayList<Integer> kyo = new ArrayList<>(list1);        //list1 요소 전부 추가
		kyo.retainAll(list2);									//list2와 겹치는 요소만 남기고 전부 삭제 (=교집합)

		ArrayList<Integer> cha = new ArrayList<>(list1);
		cha.removeAll(list2);									//list2와 겹치는 요소를 전부 삭제 (=차집합)

		ArrayList<Integer> hap = new ArrayList<>(list1);        //list1
		hap.removeAll(list2);									//list1과 list2의 교집합 제거
		hap.addAll(list2);										//list2를 추가 (=합집합)

		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}