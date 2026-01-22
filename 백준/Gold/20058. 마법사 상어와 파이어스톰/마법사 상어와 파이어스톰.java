import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {
  static int N, Q;
  static int[] Line;
  static int[][] board;
  static int[] dx = {-1,1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  static int maxIce = 0;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = 1 << Integer.parseInt(st[0]);
      Q = Integer.parseInt(st[1]);

      board = new int[N][N];

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          board[i][j] = Integer.parseInt(row[j]);
        }
      }
      
      String[] info = br.readLine().split(" ");
      Line = new int[info.length];
      for (int i = 0; i < info.length; i++) {
        Line[i] = Integer.parseInt(info[i]);
      }

      for (int L : Line) {
        // 부분 격자로 나누기
        int M = 1 << L;

        for (int sr = 0; sr < N; sr += M) {
          for (int sc = 0; sc < N; sc += M) {
            // 부분 격자 시작 부분
            rotate(sr,sc,M); // 90도 회전
          }
        }
        
        // 얼음을 녹이기
        meltIce();

      }
      int total = 0;
      boolean[][] visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          total += board[i][j];
          if (!visited[i][j] && board[i][j] > 0) {
            maxIce = Math.max(maxIce, bfs(visited, i, j));
          }
        }
      }
      System.out.println(total);
      System.out.println(maxIce);
   }
   static void meltIce() {
    List<int[]> melt = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 0) continue;

        int cnt = 0;
        for (int d = 0; d < 4; d++) {
          int nx = dx[d] + i; int ny = dy[d] + j;
          if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

          if (board[nx][ny] > 0) cnt++;
        }

        if (cnt < 3) melt.add(new int[]{i, j});
      }
    }

    for (int[] m : melt) {
      board[m[0]][m[1]]--;
    }
   }
   static int bfs(boolean[][] visited, int x, int y) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x, y});

    visited[x][y] = true;
    int size = 1;
    while (!queue.isEmpty()) {

      int[] curr = queue.poll();
      int cx = curr[0]; int cy = curr[1]; 

      for (int d = 0; d < 4; d++) {
        int nx = dx[d] + cx; int ny = dy[d] + cy;

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if (visited[nx][ny] || board[nx][ny] == 0) continue;
        
        visited[nx][ny] = true;
        size++;
        queue.add(new int[]{nx, ny});
      }
      
    }

    return size;
   }
   static void rotate(int sr, int sc, int M) {
    int[][] temp = new int[M][M];

    // 부분 격자 복사
    for (int r = 0; r < M; r++) {
      for (int c = 0; c < M; c++) {
        temp[r][c] = board[sr+r][sc+c];
      }
    }

    // 90도 회전 후 덮어쓰기
    for (int r = 0; r < M; r++) {
      for (int c = 0; c < M; c++) {
        board[c + sr][sc + (M -1 -r)] = temp[r][c]; 
      }
    }
   }
}