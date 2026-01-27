import java.io.*;
import java.util.Arrays;

class Main {
  static int N, K;
  static int[][] dist;
  static boolean[] visited;
  static int minTime = Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      K = Integer.parseInt(st[1]);

      dist = new int[N][N];
      visited = new boolean[N];
      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          dist[i][j] = Integer.parseInt(row[j]);
        }
      }


      for (int k = 0; k < N; k++)  {
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            if (i == j) continue;
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }

      dfs(K, 0, 0);

      System.out.println(minTime);

   }
   static void dfs(int cur, int depth, int time) {
    if (depth == N) {
      minTime = Math.min(minTime, time);
      return;
    }

    for (int next = 0 ; next < N; next++) {
      if (!visited[next]) {
        visited[next] = true;
        dfs(next, depth + 1, time + dist[cur][next]);
        visited[next] = false;
      }
    }
   }
}
