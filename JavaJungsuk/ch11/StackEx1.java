package ch11;

import java.util.Stack;

//Stack으로 웹 브라우저 '뒤로', '앞으로' 버튼 기능 구현
public class StackEx1 {
	public static Stack back 	= new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		goURL("1.구글");
		goURL("2.네이버");
		goURL("3.다음");
		goURL("4.줌");
		
		printStatus();
		
		goBack();
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		printStatus();
		
		goBack();
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		printStatus();
		
		goForward();
		System.out.println("= '앞으로' 버튼을 누른 후 =");
		printStatus();
		
		goURL("https://www.bing.com/");
		System.out.println("= 새로운 주소로 이동 후 =");
		printStatus();
	}
	
	//상태 출력
	public static void printStatus() {
		System.out.println("back:"+back);
		System.out.println("forward:"+forward);
		System.out.println("현재화면은 '"+back.peek()+"'입니다.");
		System.out.println();
	}
	
	//URL 이동
	public static void goURL(String url) {
		back.push(url);
		if(!forward.isEmpty()) {
			forward.clear();	//뒤로 상태에서 새 페이지 누를 경우 앞페이지 기록 소멸
		}
	}
	
	//앞으로 : 다음 페이지로
	public static void goForward() {
		if(!forward.isEmpty()) {
			back.push(forward.pop());
		}
	}
	
	//뒤로 : 이전 페이지로 
	public static void goBack() {
		if(!back.isEmpty()) {
			forward.push(back.pop());
		}
	}
}
