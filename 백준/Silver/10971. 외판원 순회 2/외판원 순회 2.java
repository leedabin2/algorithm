import java.io.*;

class Main {
  static int[][] w;
  static boolean[] visited;
  static int N;
  static int min = Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());

      w = new int[N][N];

      for (int i = 0; i < N; i++) {
        String[] st = br.readLine().split(" ");

        for (int j = 0; j < N; j++) {
          w[i][j] = Integer.parseInt(st[j]);
        }

      }

      visited = new boolean[N];
      visited[0] = true;

      dfs(0,  0, 0, 1);

      System.out.println(min);
   }
   static void dfs(int start, int now, int cost, int cnt) {
    if (cnt == N) {
      // 모두 방문한 경우
      if (w[now][start] != 0) {
        min = Math.min(min, cost + w[now][start]);
      }
      return;
    }


    for (int next = 0; next < N; next++) {
      if (!visited[next] && w[now][next] != 0) {
        visited[next] = true;
        dfs(start, next, cost + w[now][next], cnt+1);
        visited[next] = false;
      }
    }
   }
}