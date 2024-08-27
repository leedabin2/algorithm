import java.util.*;

class Solution {
    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    List<String> answer = new ArrayList<>();
    public int solution(String word) {
        
        recur("");
       
        return answer.indexOf(word);
    }
    
     public void recur(String curr) {
         
         answer.add(curr);
         
         if (curr.length() < 5) {
             for (char a : alphabet) {
                 recur(curr + a);
             }
         }
            
    }
}