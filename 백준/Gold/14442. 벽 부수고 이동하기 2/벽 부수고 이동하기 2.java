import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int M = Integer.parseInt(st[1]);
    int K = Integer.parseInt(st[2]);

    int[][] board = new int[N][M];
    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    boolean[][][] visited = new boolean[N][M][K+1];
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0,0,1,0});

    visited[0][0][0] = true;

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();
      int cx = curr[0], cy = curr[1], dist = curr[2], broken = curr[3];

      if (cx == N-1 && cy == M-1) {
        System.out.print(dist);
        return;
      }

      for (int[] dir : directions) {
        int nx = dir[0] + cx, ny = dir[1] + cy;

        if (0<= nx && nx < N && 0<=ny && ny < M ) {
          if (board[nx][ny] == 1 && broken < K && !visited[nx][ny][broken+1]) {
            visited[nx][ny][broken+1] = true;
            queue.add(new int[]{nx,ny,dist+1,broken+1});
            
          } else if (board[nx][ny] == 0 && !visited[nx][ny][broken]) {
            visited[nx][ny][broken] = true;
            queue.add(new int[]{nx,ny,dist+1,broken});
          }
        }
      }
    }

    System.out.print(-1);
  }
} 