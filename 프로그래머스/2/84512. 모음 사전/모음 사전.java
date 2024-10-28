import java.util.*;
class Solution {
    List<String> res = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
    
        recur("");
        Collections.sort(res);
        answer = res.indexOf(word);
     
        return answer;
    }
    private void recur(String curr) {
        String[] arr = {"A", "E", "I", "O", "U"};
        
        if (curr.length() > 5) {
            return;
        }
        res.add(curr);
        for (String a : arr) {
            recur(curr+a);
        }
    }
}