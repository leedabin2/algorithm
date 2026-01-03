import java.util.*;

class Solution {
    static int cnt = -1;
    static int answer = 0;
    static char[] alpabet = new char[]{'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        
        dfs(word, new StringBuilder());
         
        return answer;
    }
    static void dfs(String word, StringBuilder sb) {
        if (sb.length() > 5) {
            return;
        }
        
        cnt++;
        
        if (sb.toString().equals(word)) {
            answer = cnt;
            return;
        }
        
        
        for (int i = 0 ; i < 5; i++) {
            sb.append(alpabet[i]);
            dfs(word, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}