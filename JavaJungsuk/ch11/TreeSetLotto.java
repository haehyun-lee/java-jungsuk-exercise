package ch11;

import java.util.TreeSet;

//TreeSet 로또
public class TreeSetLotto {
	public static void main(String[] args) {
		TreeSet<Integer> tree = new TreeSet<>();

		for(int i=0; tree.size() < 6; i++) {
			int num = (int)(Math.random() * 45) + 1;
			tree.add(num);
		}
		
		System.out.println(tree);
		System.out.println(tree.descendingSet());	//역순 정렬
		System.out.println(tree.first());			//정렬순에서 첫번째 객체
		System.out.println(tree.last());			//정렬순에서 마지막 객체
		System.out.println(tree.headSet(10));		//지정된 객체보다 작은 값의 객체들
		System.out.println(tree.tailSet(10));		//지정된 객체보다 큰 값의 객체들
		System.out.println(tree.pollFirst());		//제일 작은 값의 객체
		System.out.println(tree.pollLast());		//제일 큰 값의 객체
		System.out.println(tree.subSet(10, 30));	//범위 검색 (마지막 값 포함X)
		System.out.println(tree.subSet(10, true, 30, true));	//범위 검색 (첫 값, 마지막 값 포함O)		
	}
}
