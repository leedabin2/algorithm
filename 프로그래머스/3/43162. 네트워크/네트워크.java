import java.util.*;

class Solution {
  static boolean[] visited;
  
    public int solution(int n, int[][] computers) {
        int count = 0;

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
          if (!visited[i]) {
            bfs(i,n,computers);
            count++;
          }
        }
        return count;
    }
  private static void bfs(int node, int n, int[][] computers) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(node);

    visited[node] = true;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      
      for (int nxt = 0; nxt < n; nxt++) {
        if (!visited[nxt] && computers[cur][nxt] == 1) {
          visited[nxt] = true;
          queue.add(nxt);
        }
      }
    }

  }
}