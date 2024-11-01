import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        if (!Arrays.toString(words).contains(target)) {
            return 0;
        }
        
        Deque<String> q = new ArrayDeque<>();
        q.offer(begin);
        boolean[] visited = new boolean[words.length];
        while(!q.isEmpty()) {
           
            for (int i = 0; i < q.size(); i++) {
                String curr = q.poll();
                if(curr.equals(target)) {
                    return answer;
                }
                for (int j = 0 ; j < words.length; j++) {
                    if (!visited[j] && check(curr,words[j])) {
                        visited[j] = true;
                        q.offer(words[j]);
                    }
                }
                
            }
            answer++;
         
        }
        return answer;
    }
    private boolean check(String word1, String word2) {
    
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        
        if (diff == 1) return true;
        return false;
    }
}