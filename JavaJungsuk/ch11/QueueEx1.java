package ch11;

import java.util.*;

//Queue - Unix의 history명령어 구현, FIFO구조
public class QueueEx1 {
	static Queue q = new LinkedList();		//Queue는 인터페이스로만 정의되어 있고 별도의 클래스는 존재X
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) {
			System.out.print(">>");
			try {
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();
				
				if(input.isEmpty()) { continue; }
				
				if(input.equalsIgnoreCase("q")) {
					System.exit(0);
				}else if(input.equalsIgnoreCase("help")) {
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				}else if(input.equalsIgnoreCase("history")) {
					int i = 0;
					save(input);				//입력명령어 저장
					
					LinkedList tmp = (LinkedList)q;
					ListIterator it = tmp.listIterator();
					
					while(it.hasNext()) {
						System.out.println(++i + "." + it.next());
					}
				}else {
					save(input);				//입력명령어 저장
					System.out.println(input);
				}
				
			}catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		}

	}
	
	//Queue에 입력 저장
	public static void save(String input) {
		if(!input.isEmpty()) {
			q.offer(input);
		}
		
		if(q.size() > MAX_SIZE) {				//최대크기 넘어가면 하나 삭제
			q.remove();
		}
	}
}
