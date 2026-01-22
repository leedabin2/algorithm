import java.io.*;

class Main {
  static int N, M;
  static int[][] board;
  static int[] dx = {1,1,1};
  static int[] dy = {-1,0,1};
  static int min = Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);

      board = new int[N][M];

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
          board[i][j] = Integer.parseInt(row[j]);
        }
      }

      for (int j = 0; j < M; j++) {
        for (int d : new int[]{0,1,2}) {
          dfs(0, j, d,board[0][j]);
        }
      }

      System.out.println(min);
   }
   static void dfs(int depth, int j, int d, int total) {
    if (depth == N-1) {
      min = Math.min(min, total);
      return;
    }

    for (int dir = 0; dir < 3; dir++) {
      int nd = dir;
      int nx = dx[dir] + depth; int ny = dy[dir] + j;
      if (nd == d) {
        // 이전 방향과 같으면 안 됨
        continue;
      }
      else {
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

        dfs(nx, ny, nd, total + board[nx][ny]);

      }
    }


   }
}