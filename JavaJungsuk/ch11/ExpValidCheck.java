package ch11;

import java.util.*;

//Stack - 입력한 수식의 (괄호)가 올바른지 체크
public class ExpValidCheck {

	public static void main(String[] args) {
		System.out.print("수식을 입력하세요. \n>> ");
		Scanner sc = new Scanner(System.in);
		
		Stack st = new Stack();
		String expression = sc.nextLine();
		int cnt = 0;
		
		System.out.println("expression:" + expression);
		
		try {
			for(int i=0; i < expression.length(); i++) {
				char ch = expression.charAt(i);
				
				if(ch == '(') {
					st.push(ch+"");
				}else if(ch == ')') {
					st.pop();				//EmptyStackException => 매칭되는 '('가 없을 경우
					cnt++;
				}
			}
			
			if(st.isEmpty()) {
				System.out.println("괄호가 일치하며, 괄호는 " + cnt + "쌍 있습니다.");
			}else {
				System.out.println("괄호가 일치하지 않습니다.");						//'('가 Stack에서 안꺼내짐 => 매칭되는 ')'를 발견하지 못함
			}
		}catch(EmptyStackException e) {
			System.out.println("괄호가 일치하지 않습니다.");
		}
	}
}
