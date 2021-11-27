package ch11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.TreeSet;

public class Exercise11_2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(6);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(7);

        HashSet<Integer> set = new HashSet<>(list);    //중복 제거 { 3, 6, 2, 7 }
        TreeSet<Integer> tset = new TreeSet<>(set);    //자체 정렬 { 2, 3, 6, 7 }
        Stack<Integer> stack = new Stack<>();
        stack.addAll(tset);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());    //LIFO 7, 6, 3, 2
        }
    }
}
