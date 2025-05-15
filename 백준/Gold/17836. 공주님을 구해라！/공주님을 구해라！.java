import java.util.*;
import java.io.*;

class Main {
  static int N, M, T, min;
  static int[][] board;
  static boolean[][] visited;
  static int[][] directions;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    T = Integer.parseInt(st[2]);

    board = new int[N][M];
    visited = new boolean[N][M];
    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    min = Integer.MAX_VALUE;
    directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    bfs(0,0,0);

    if (min <= T) {
      System.out.print(min);
    } else {
      System.out.print("Fail");
    }
  }
  static void bfs(int x, int y, int t) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x,y,t});
    visited[x][y] = true;
    int gramTime = Integer.MAX_VALUE;
    while(!queue.isEmpty()) {
      int[] curr = queue.poll();
      int cx = curr[0], cy = curr[1], time = curr[2];

      if (time > T) continue;
      if ( cx == N -1 && cy == M - 1) {
        min = Math.min(min,time);
      }
      
      if (board[cx][cy] == 2 ) {
        int distToPrincess = (N-1-cx) + (M-1-cy);
        gramTime = time + distToPrincess;
      }

      for (int[] dir : directions) {
        int nx= dir[0] + cx, ny = dir[1] + cy;

        if (0<=nx && nx < N && 0<=ny && ny < M && !visited[nx][ny] && board[nx][ny] != 1) {
         
            visited[nx][ny] = true;
            queue.add(new int[]{nx,ny,time+1});
          
        }
      }

      
    }
    min = Math.min(min, gramTime);
  }
} 