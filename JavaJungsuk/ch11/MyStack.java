package ch11;

import java.util.EmptyStackException;
import java.util.Vector;

//Stack 자료구조 직접 구현해보기
public class MyStack extends Vector {
	//Stack에 객체를 저장한다.
	public Object push(Object item) {
		addElement(item);
		return item;
	}
	
	//Stack의 맨 위에 저장된 객체를 꺼낸다.
	public Object pop() {
		Object obj = peek();
		removeElementAt(size() -1);
		return obj;
	}
	
	//Stack의 맨 위에 저장된 객체를 반환.
	public Object peek() {
		int len = size();
		
		//Stack이 비어있는을 경우 예외 발생
		if(len == 0) {
			throw new EmptyStackException();	//RuntimeException
		}
		return elementAt(len -1);
	}
	
	//Stack이 비었는지 알려준다.
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//Stack에서 주어진 객체를 찾아서 그 위치를 반환
	public int search(Object o) {
		int i = lastIndexOf(o);
		
		if(i >= 0) {
			return size() - i;
		}
		
		return -1;
	}
}
