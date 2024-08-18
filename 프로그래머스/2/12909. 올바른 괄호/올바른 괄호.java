import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // s 를 스택으로 만들기
        // 새로운 new 스택에서 s스택이랑 비교하며 넣기
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++ ) {
            stack.add(s.charAt(i));
        }
        
        Deque<Character> comp = new ArrayDeque<>();
        comp.add(stack.poll());
        
        if (comp.peek() == ')') {
            answer = false;
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                comp.add(stack.poll());
            } else if (stack.peek() == ')') {
                comp.pollLast();
                stack.poll();
            }
            
        }
        if (!comp.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}