import java.io.*;
import java.util.*;

class Main {
  static int N;
  static double answer = 0.0;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static double[] prob = new double[4];
  static boolean[][] visited = new boolean[30][30];
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[0]);
      prob[0] = Integer.parseInt(st[1]) / 100.0;
      prob[1] = Integer.parseInt(st[2]) / 100.0;
      prob[2] = Integer.parseInt(st[3]) / 100.0;
      prob[3] = Integer.parseInt(st[4]) / 100.0;
      
      visited[15][15] = true;
      dfs(15, 15, 0, 1.0);

      System.out.println(answer);
   }
   static void dfs(int x, int y, int depth, double p
   ) {
    if (depth == N) {
      answer += p;
      return;
    }

    for (int i =0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (!visited[nx][ny]) {
        visited[nx][ny] = true;
        dfs(nx, ny, depth + 1, p * prob[i]);
        visited[nx][ny] = false;
      }
    }
   }

  
}