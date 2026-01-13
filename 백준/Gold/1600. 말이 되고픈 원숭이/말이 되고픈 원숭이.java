import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

class Main {
  static int N,M,K;
  static int[][] board;
  static boolean[][][] visited;
  static int[] dx = {-1,1,0,0}; // 상 하 좌 우
  static int[] dy = {0,0,-1,1};
  static int[] horseDx = {-2, -1, 1, 2, 2, 1, -1, -2};
  static int[] horseDy = {1, 2, 2, 1, -1, -2, -2, -1};
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      K = Integer.parseInt(br.readLine());

      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[1]); M = Integer.parseInt(st[0]);

      board = new int[N][M];

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < M; j++) {
          board[i][j] = Integer.parseInt(row[j]);
        }
      }

      System.out.println(bfs());
   }
   static int bfs() {
    Deque<int[]> q = new ArrayDeque<>();
    visited = new boolean[K+1][N][M];

    q.add(new int[]{0, 0, 0, 0}); // x y time 말이동횟수
    visited[0][0][0] = true;

    while (!q.isEmpty()) { 

      int[] curr = q.poll();
      int x = curr[0]; int y = curr[1]; int time = curr[2]; int used = curr[3];

      if (x == N-1 && y == M-1) {
        return time;
      }

      // 상하좌우 이동
      for (int d = 0; d < 4; d++) {
        int nx = dx[d] + x; int ny = dy[d] + y;

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if (visited[used][nx][ny] || board[nx][ny] == 1) continue;

        visited[used][nx][ny] = true;
        q.add(new int[]{nx, ny, time + 1, used});
      }

      // K 번 말 흉내
      if (used < K) {
        for (int d = 0; d < 8; d++) {
          int nx = horseDx[d] + x; int ny = horseDy[d] + y;
          if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
          if (visited[used+1][nx][ny] || board[nx][ny] == 1) continue;

          visited[used+1][nx][ny] = true;
          q.add(new int[]{nx, ny, time + 1, used + 1});
        }
      }
    }
    return -1;
  }
 }