import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
  static int answer = 0;
  static char[][] board;
  static int R, C;
  static int[] alpabet;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    // 1 : 25

    alpabet = new int[101];

    String[] st = br.readLine().split(" ");
    R = Integer.parseInt(st[0]);
    C = Integer.parseInt(st[1]);

    board = new char[R][C];

    for (int i =0; i < R; i++) {
      String[] row = br.readLine().split("");

      for (int j = 0; j < C; j++) {
        board[i][j] = row[j].charAt(0);
      }
    }

    alpabet[board[0][0] - 0] = 1;

    dfs(0, 0, 1);
    
    System.out.print(answer);


  }
  static private void dfs(int x, int y, int cnt) {

    answer = Math.max(cnt, answer);

    char cur = board[x][y];

    for (int[] dir : directions) {
      int nx = dir[0] + x;
      int ny = dir[1] + y;

      if (nx >=0 && nx < R && ny >=0 && ny < C) {
        char next = board[nx][ny];
        if (alpabet[next] != 1) {
          alpabet[next]++;
          dfs(nx, ny, cnt+1);
          alpabet[next]--;
        }
      }
    }
  }
}
