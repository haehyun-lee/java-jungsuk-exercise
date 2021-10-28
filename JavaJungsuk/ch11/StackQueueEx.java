package ch11;

import java.util.*;

public class StackQueueEx {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		
		st.push(0);
		st.push(1);
		st.push(2);
		
		while(!st.empty()) {
			System.out.println(st.pop());
		}
	}
}
