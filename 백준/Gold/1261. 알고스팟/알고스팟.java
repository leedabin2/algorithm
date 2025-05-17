import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");

    int M = Integer.parseInt(st[0]);
    int N = Integer.parseInt(st[1]);

    int[][] board = new int[N][M];
    boolean[][] visited = new boolean[N][M];

    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split("");
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0,0,0});
    visited[0][0] = true;

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();

      int cx = curr[0], cy = curr[1], block = curr[2];
      if (cx == N-1 && cy == M-1) {
        System.out.print(block);
        return;
      }

      for (int[] dir : directions) {
        int nx = dir[0] + cx, ny = dir[1] + cy;

        if (0<= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] ) {
          if (board[nx][ny] == 1) {
            visited[nx][ny] = true;
            queue.addLast(new int[]{nx,ny,block+1});
          } else if (board[nx][ny] == 0) {
            visited[nx][ny] = true;
            queue.addFirst(new int[]{nx,ny,block});
          }
        }
      }
    }
    
  }
} 