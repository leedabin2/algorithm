import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int start = 0;
        int end = p.length();
        List<String> res = new ArrayList<>();
        
        while (start <= t.length() - p.length()) {
            
            String subStr = t.substring(start,end);
            res.add(subStr);
            
            start++;
            end++;
        }
        
        long intToP = Long.parseLong(p);
        for (String r : res) {
            long num = Long.parseLong(r);
            
            if (num <= intToP) {
                answer++;
            }
        }
        return answer;
    }
}