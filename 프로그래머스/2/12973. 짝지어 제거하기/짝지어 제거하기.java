import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        // 12 : 6
        Deque<Character> stack = new ArrayDeque<>();
        
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peekLast() == ch) {
                stack.removeLast();
            } else {
                stack.addLast(ch);
            }
        }
        
        if (stack.isEmpty()) answer = 1;
        else answer = 0;
        


        return answer;
    }
}