import java.util.*;
import java.io.*;

class Main {
  static int N, M, count;
  static int[][] board;
  static boolean[][] visited;
  static Deque<int[]> queue;
  static int[][] directions;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    board = new int[N][M];
    visited = new boolean[N][M];
    directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0 ; j < M; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }


    count = 0;
    int max = 0;
    for (int i = 0 ; i < N; i++) {
      for (int j =0; j < M; j++) {
        if (board[i][j] == 1 && !visited[i][j]) {
          visited[i][j] = true;
          count++;
          max = Math.max(max,bfs(i,j));
        }
      }
    }
    
    System.out.println(count);
    System.out.print(max);
  }

  static int bfs(int x, int y) {
    queue = new ArrayDeque<>();
    queue.add(new int[]{x,y});
    int width = 1;
 
    while(!queue.isEmpty()) {
      int[] curr = queue.poll();
      int cx = curr[0], cy = curr[1];
      
      for (int[] dir: directions){
        int nx = dir[0] + cx, ny = dir[1] + cy;

        if (0<=nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 1){
          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            width++;
            queue.add(new int[]{nx,ny});
            
          }
        }
      }
    }

    return width;
  }

  
}