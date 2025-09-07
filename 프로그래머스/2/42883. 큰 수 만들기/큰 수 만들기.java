import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        // 1 2 3 1 2 3 4
        // 현재거보다 다음게 작으면 현재거 pop
        
        int cnt = 0;
        Stack<Character> stack = new Stack<>();
        
        char[] numbers = number.toCharArray();
        
        
        for (char num : numbers) {
            while(!stack.isEmpty() && cnt < k && stack.peek() < num) {
                stack.pop();
                cnt++;
            }
            stack.push(num); 
        }
        
        
        while(cnt < k) {
            stack.pop();
            cnt++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char st : stack) {
            sb.append(st);
        }
        
      

        
        
        return sb.toString();
    }
}