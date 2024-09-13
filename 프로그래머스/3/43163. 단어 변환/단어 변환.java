import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int check = 0;
        for (String word : words) {
            if (word.equals(target)) {
                check++;
            }
            continue;   
        }
      
        if (check == 0) {
            return 0;
        }
        
        boolean[] visited = new boolean[words.length];  
          int answer = 0;
        Deque<String> q = new ArrayDeque<>();
        q.offer(begin);
         while (!q.isEmpty()) {
            int size = q.size();  
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                
                if (curr.equals(target)) {
                    return answer;
                }

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && checkOne(curr, words[j])) {
                        visited[j] = true; 
                        q.offer(words[j]);  
                    }
                }
            }
            answer++; 
        }
        
        return answer;
    }
    
    private boolean checkOne(String word1, String word2){
        int same = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != (word2.charAt(i))) {
                same++;
            }
            continue;
        }
        
        if(same == 1) {
            return true;
        }
        return false;
    }
    
}