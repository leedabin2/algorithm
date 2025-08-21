import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        
    
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(answer);
        
        
        String[] result = answer.get(0).split(" ");
        
        return result;
    }
    static private void dfs(int cnt, String start, String word, String[][] tickets) {
        if (cnt == tickets.length) {
            answer.add(word);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], word + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}