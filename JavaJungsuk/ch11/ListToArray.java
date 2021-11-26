package ch11;

import java.util.*;

public class ListToArray {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		for(int i=0; list.size() < 10; i++) {
			list.add("text" + i);
		}
		
		String[] arr = list.toArray(new String[list.size()]);
	}
}


/*
List<Integer> list = new ArrayList<Integer>();

for(int i=0; list.size() < 10; i++) {
	list.add(i);
}

int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
*/