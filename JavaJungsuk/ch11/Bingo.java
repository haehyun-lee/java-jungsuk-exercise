package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//HashSet 빙고판 
public class Bingo {

	public static void main(String[] args) {
		Set set = new HashSet();
		int[][] board = new int[5][5];
		
		for(int i=0; set.size() < 25; i++) {
			set.add((int)(Math.random() * 50 + 1));						//HashSet 요소로 랜덤 값 추가	
		}
		
		Iterator it = set.iterator();									//HashSet 요소 접근용 Iterator
		
		for(int i =0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = Integer.parseInt(it.next().toString());	//next() 반환 값은 Object
				System.out.print(String.format("%3d", board[i][j]));
//				System.out.print(board[i][j] > 10 ? " " : "  " + board[i][j])E
			}
			System.out.println();
		}
	}
}
