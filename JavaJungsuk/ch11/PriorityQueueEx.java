package ch11;

import java.util.PriorityQueue;
import java.util.Queue;

//PriorityQueue : Queue인터페이스의 구현체, 우선순위가 높은 것부터 꺼냄
public class PriorityQueueEx {
	public static void main(String[] args) {
		Queue pq = new PriorityQueue();
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		
		Object obj = null;
		
		while((obj = pq.poll()) != null) {		//숫자가 작은 것(=우선순위가 높은 것)부터 꺼냄
			System.out.println(obj);
		}
	}
}
