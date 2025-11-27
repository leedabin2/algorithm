import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
  static int N, M;
  static int[] dx = new int[]{0, 0, -1, 1};
  static int[] dy = new int[]{1, -1, 0, 0};
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[1]);
      M = Integer.parseInt(st[0]);

      int[][] board = new int[N][M];
      Deque<int[]> q = new ArrayDeque<>();
      boolean[][] visited = new boolean[N][M];

      boolean isFull = true;
      for (int i =0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
          board[i][j] = Integer.parseInt(row[j]);

          if (board[i][j] == 0) isFull = false;
          if (board[i][j] == 1) {
            q.add(new int[]{i, j});
            visited[i][j] = true;
          }
        }
      }
    
      if (isFull) {
        System.out.println(0); // 이미 토마토가 모두 익어있는 상태
        return;
      }

      while (!q.isEmpty()) { 
        int[] curr = q.poll();

        int cx = curr[0], cy = curr[1];

        for (int d = 0; d < 4; d++) {
          int nx = dx[d] + cx, ny = dy[d] + cy;

          if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

          if (!visited[nx][ny] && board[nx][ny] != -1) {
            visited[nx][ny] = true;
            board[nx][ny] = board[cx][cy] + 1;
            q.add(new int[]{nx, ny});
          }
        }
      }

      boolean isOut = false;
      int total = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (board[i][j] == 0) isOut = true;
          total = Math.max(board[i][j], total);
        }
      
      }

      System.out.println(isOut ? -1 : total - 1);

    }
}