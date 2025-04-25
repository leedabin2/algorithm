import java.util.*;
import java.io.*;

class Main {
  static int N, M, K, total;
  static int[][] board;
  static boolean[][] visited;
  static int[][] directions;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    M = Integer.parseInt(st[0]);
    N = Integer.parseInt(st[1]);
    K = Integer.parseInt(st[2]);

    board = new int[M][N];

    for (int i = 0; i < K; i++) {
      String[] info = br.readLine().split(" ");
      int col = Integer.parseInt(info[0]);
      int row = Integer.parseInt(info[1]);
      int colMax = Integer.parseInt(info[2]);
      int rowMax = Integer.parseInt(info[3]);

      for (int j = row; j < rowMax; j++) {
        for (int k = col; k < colMax; k++) {
          board[j][k] = 1;
        }
      }
    }
    List<Integer> widthSize = new ArrayList<>();
    visited = new boolean[M][N];
    directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    for (int i =0 ; i < M; i++) {
      for (int j =0; j < N; j++) {
        if (board[i][j] == 0 && !visited[i][j]) {
          total = 1;
          dfs(i,j);
          widthSize.add(total);
        }
      }
    }
    Collections.sort(widthSize);
  System.out.println(widthSize.size());
  for (int i = 0 ; i < widthSize.size(); i++) {
    System.out.print(widthSize.get(i) + " ");
  }
  }

  private static void dfs(int x, int y) {

    visited[x][y] = true;
      for (int[] dir : directions) {
        int nx = dir[0] + x;
        int ny = dir[1] + y;

        if (0<= nx && nx < M && 0<= ny && ny < N && board[nx][ny] == 0) {
          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            total++;
            dfs(nx,ny);
          }
        }
      }
    
  }
}