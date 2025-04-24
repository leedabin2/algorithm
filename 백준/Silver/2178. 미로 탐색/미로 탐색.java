import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static int[][] board;
  static Deque<int[]> queue;
  static boolean[][] visited;
  static int[][] directions;
  public static void main(String[] args) throws IOException  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    board = new int[N][M];

    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split("");
      for (int j = 0; j < M ; j++) {
        board[i][j] = Integer.parseInt(line[j]);
      }
    }
    queue = new ArrayDeque<>();
    visited = new boolean[N][M];
    directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    System.out.println(bfs(0,0,1));

  }

  private static int bfs(int x, int y,int d) {
      queue.add(new int[]{x,y,d});
      visited[x][y] = true;
      while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int cx = curr[0];
        int cy = curr[1];
        int dist = curr[2];

        if (cx == N-1 && cy == M-1) {
            return dist;
        }
        for (int[] dir : directions) {
          int nx = dir[0] + cx;
          int ny = dir[1] + cy;

          if (0 <= nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == 1){
            if (!visited[nx][ny]){
              visited[nx][ny] = true;
              queue.add(new int[]{nx,ny,dist+1});
            }
          }
        } 
      }
      return -1;
  }
}