import java.util.*;
import java.io.*;
// 4: 15 -> 4 :54
class Main {
  static int N, M;
  static int[][] board;
  static boolean[][] visited;
  static int[][] directions;
  static Deque<int[]> queue;
  public static void main(String[] args) throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    board = new int[M][N];
    for (int i = 0 ; i < M ; i++) {
      String[] line = br.readLine().split(" ");
      for (int j = 0; j < N; j++ ) {
        board[i][j] = Integer.parseInt(line[j]);
      }
    }
    
    queue = new ArrayDeque<>();
    visited = new boolean[M][N];
    directions = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1) {
          queue.add(new int[]{i,j});
          visited[i][j] = true;
        }
      }
    }

    bfs();

    int maxDay = 0;
    for (int i = 0; i < M; i++) {
      for (int j =0; j < N; j++) {
        if (board[i][j] == 0) {
          System.out.println(-1);
          return;
        }
        else {
          maxDay = Math.max(maxDay, board[i][j]);
        }
      }
    }

     System.out.println(maxDay-1);
  }

  private static void bfs() {
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      
      int cx = cur[0];
      int cy = cur[1];

      for (int[] dir : directions) {
        int nx = dir[0] + cx;
        int ny = dir[1] + cy;

        if (0<= nx && nx < M && 0<= ny && ny < N && board[nx][ny] == 0) {
          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            board[nx][ny] = board[cx][cy] + 1;
            queue.add(new int[]{nx,ny});
          }
        }
      }
    }
  }

}