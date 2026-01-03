import java.util.*;

class Solution {
    static boolean[] visited;
    static Deque<Integer> queue;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int start, int[][] computers) {
        
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            for (int next = 0 ; next < computers.length; next++) {        if (computers[curr][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
                
            }
        }
        
        
    }
}