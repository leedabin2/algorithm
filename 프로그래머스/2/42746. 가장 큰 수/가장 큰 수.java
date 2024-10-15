import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> numberToString = new ArrayList<>();
        for (int n: numbers) {
            numberToString.add(Integer.toString(n));
            
        }
    
        numberToString.sort((a,b)->(b+a).compareTo(a+b));
        for (String n : numberToString) {
            answer += n;
        }
        
        if (numberToString.get(0).equals("0")) {
            return "0";
        }
        
        return answer;
    }
}