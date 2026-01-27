import java.io.*;
import java.util.*;

class Main {
  static int N, Q;
  static List<List<int[]>> graph;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      Q = Integer.parseInt(st[1]);

      graph = new ArrayList<>();
      for (int i = 0; i <= N; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < N-1; i++) {
        String[] info = br.readLine().split(" ");
        int a = Integer.parseInt(info[0]);
        int b = Integer.parseInt(info[1]);
        int cost = Integer.parseInt(info[2]);

        graph.get(a).add(new int[]{b, cost});
        graph.get(b).add(new int[]{a, cost});
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < Q; i++) {
        String[] question = br.readLine().split(" ");
        int K = Integer.parseInt(question[0]);
        int v = Integer.parseInt(question[1]);
      
        sb.append(bfs(K, v)).append('\n');

      }

      System.out.println(sb.toString());
   }

   static int bfs(int K, int start) {
    Deque<int[]> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[N+1];
    queue.add(new int[]{start, Integer.MAX_VALUE});
    visited[start] = true;
    int count = 0;
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();

      int cur = curr[0]; 
      int cost = curr[1];

      for (int[] next : graph.get(cur)) {
        int nxt = next[0];
        int nextCost = next[1];

        if (visited[nxt]) continue;
        int newMinCost = Math.min(nextCost, cost);
        if (newMinCost >= K) {
          count++;
          visited[nxt] = true;
          queue.add(new int[]{nxt, nextCost});
        }
      }
    }

    return count;
   }
}