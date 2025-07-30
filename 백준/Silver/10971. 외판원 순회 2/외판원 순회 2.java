import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int[][] cost;
  static int minCost = Integer.MAX_VALUE;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    cost = new int[N][N];

    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j =0; j < N; j++) {
        cost[i][j] = Integer.parseInt(row[j]);
      }
    }

    visited = new boolean[N];
    visited[0] = true;
    dfs(0, 0, 0, 1); 

    System.out.println(minCost);
  }
  static void dfs(int start, int total, int now, int cnt) {
    if (cnt == N) {
      if (cost[now][start] != 0) {
        minCost = Math.min(minCost, total + cost[now][start]);
      }
      return;
    }
    for (int next = 0; next < N; next++) {
      if (!visited[next] && cost[now][next] != 0) {
        visited[next] = true;
        dfs(start, total + cost[now][next], next, cnt+1);
        visited[next] = false;
      }

    }


  }

} 