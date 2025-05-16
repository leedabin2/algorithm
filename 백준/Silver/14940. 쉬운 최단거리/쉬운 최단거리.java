import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] board = new int[n][m];
    boolean[][] visited = new boolean[n][m];
    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    Deque<int[]> queue = new ArrayDeque<>();
    int[][] dist = new int[n][m];

    int startX = 0, startY = 0;

    for (int i = 0; i < n; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(row[j]);
        if (board[i][j] == 2) {
          startX = i;
          startY = j;
        }
        dist[i][j] = -1;
      }
    }

    queue.add(new int[]{startX,startY});
    visited[startX][startY] = true;
    dist[startX][startY] = 0;

    while(!queue.isEmpty()) {
      int[]  curr = queue.poll();

      int cx = curr[0], cy = curr[1];

  
      for (int[] dir : directions) {
        int nx = dir[0] + cx, ny = dir[1] + cy;

        if (0<=nx && nx < n && 0<= ny && ny < m && board[nx][ny] == 1) {
          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            dist[nx][ny] = dist[cx][cy] + 1;
            queue.add(new int[]{nx,ny});
          }
        }
      }
    }

    for (int i =0; i < n; i++) {
      for (int j =0; j < m; j++) {
        if (board[i][j] == 0) {
          dist[i][j] = 0;
        }
        System.out.print(dist[i][j] + " ");
      }
      System.out.println();
    }

    
  }


} 