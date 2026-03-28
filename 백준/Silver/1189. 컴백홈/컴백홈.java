import java.io.*;
import java.util.*;

class Main {
  static int answer = 0;
  static int R, C, K;
  static char[][] board;
  static boolean[][] visited;
  static int[] dx = new int[]{0, 0, -1, 1};
  static int[] dy = new int[]{-1, 1, 0, 0};
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    String[] st = br.readLine().split(" ");
    R = Integer.parseInt(st[0]);
    C = Integer.parseInt(st[1]);
    K = Integer.parseInt(st[2]);

    board = new char[R][C];
    
    for (int i = 0; i < R; i++) {
      String row = br.readLine();
      for (int j = 0; j < C; j++) {
        board[i][j] = row.charAt(j);
      }
    }

    visited = new boolean[R][C];

    visited[R-1][0] = true;

    dfs(R-1, 0, 1);
    System.out.println(answer);

   }
   static void dfs(int x, int y, int dist) {
    if (x == 0 && y == C-1 && dist == K) {
      answer++;
      return;
    }

    for (int d = 0; d < 4; d++) {
      int nx = dx[d] + x; int ny = dy[d] + y;

      if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

      if (!visited[nx][ny] && board[nx][ny] == '.') {
        visited[nx][ny] = true;
        dfs(nx, ny, dist + 1);
        visited[nx][ny] = false;
      }
    }
    
   }
}