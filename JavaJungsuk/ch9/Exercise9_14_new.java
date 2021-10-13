package ch9;

import java.util.*;
import java.util.regex.*;

public class Exercise9_14_new {

	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		
		ArrayList list = new ArrayList();
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String input = s.nextLine().trim();
			
			if(input.equals("")) {
				continue;
			}else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			
			String pattern = ".*"+input+".*";		//input값으로 정규식 선언
			Pattern p =Pattern.compile(pattern);
			
			//input을 포함하는 모든 문자열 탐색
			for(int i=0; i<phoneNumArr.length; i++) {
				String phoneNum = phoneNumArr[i].replaceAll("-", "");	//특수문자 제외,정수만 추출
				
				Matcher m = p.matcher(phoneNum);
				
				if(m.find()) {
					list.add(phoneNumArr[i]);		//특수문자 포함된 원본 문자열로 추가
				}
			}
						
			//탐색 결과 유무
			if(list.size()>0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다.");
			}			
		}		
	}
}
