import java.io.*;
import java.util.*;
class Main {
  static int N;
  static boolean[] visited;
  static int[] pepoles;
  static int[][] dp;
  static List<List<Integer>> graph;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N =Integer.parseInt(br.readLine());
      String[] input = br.readLine().split(" ");
      pepoles = new int[N+1];
      for (int i = 1; i <= N; i++) {
        pepoles[i] = Integer.parseInt(input[i-1]);
      }

      graph = new ArrayList<>();
      for (int i = 0; i <= N; i++) {
        graph.add(new ArrayList<>());
      }

      for (int i = 0; i < N-1; i++) {
        String[] st =br.readLine().split(" ");

        int a = Integer.parseInt(st[0]);
        int b = Integer.parseInt(st[1]);

        graph.get(a).add(b);
        graph.get(b).add(a);
      }

      dp = new int[N+1][2];
      visited = new boolean[N+1];
      int answer = 0;
      for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
          dfs(i);
          answer += Math.max(dp[i][0], dp[i][1]);
        }
      }

      System.out.println(answer);
      
   }
   static void dfs(int cur) {
    dp[cur][0] = 0;
    dp[cur][1] = pepoles[cur];

    visited[cur] = true;

    for (int next : graph.get(cur)) {
      if (visited[next]) continue;
      dfs(next);

      dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
      dp[cur][1] += dp[next][0];
    }
   }
}