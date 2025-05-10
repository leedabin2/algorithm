import java.util.*;
import java.io.*;

class Main {
  static int N, M, max;
  static int[][] board;
  static boolean[][][] visited;
  static int[][] directions;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    board = new int[N][M];
    visited = new boolean[N][M][2];
    directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split("");
      for (int j = 0; j < M ; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    bfs(0,0);
  }
  static void bfs(int x, int y) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x,y,0,1});
    visited[x][y][0] = true;

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();
      int cx = curr[0], cy = curr[1];
      int broken = curr[2];
      int dist = curr[3];

      if (cx == N-1 && cy == M-1) {
      System.out.print(dist);
      return;
    }

      for (int[] dir : directions) {
        int nx = dir[0] + cx, ny = dir[1] + cy;

        if (0<= nx && nx < N && 0 <= ny && ny < M) {
          if (board[nx][ny] == 0 && !visited[nx][ny][broken]) {
            visited[nx][ny][broken] = true;
            queue.add(new int[]{nx,ny,broken,dist+1});

          } else if (board[nx][ny] == 1 && broken ==0 && !visited[nx][ny][1]) {
            visited[nx][ny][1] = true;
            queue.add(new int[]{nx,ny,1,dist+1});
          }

        }
      }
    }

    System.out.println(-1);
  }
}