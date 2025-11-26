import java.util.*;
import java.io.*;

class Main {
  static int n;
  static int[][] board;
  static boolean[][] visited;
  static int[] dx= {0, 0, -1, 1};
  static int[] dy = {1, -1, 0 ,0};
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
    n = Integer.parseInt(br.readLine());

    board = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] row = br.readLine().split("");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    List<Integer> result = new ArrayList<>();
    visited = new boolean[n][n];


    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && board[i][j] == 1) {
          int houses = dfs(i, j); //단지내 집의 수
          result.add(houses);
        }
      }
    }

    Collections.sort(result);
    System.out.println(result.size());
    for (int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i));
    }

  }
  static int dfs(int x, int y) {
    int cnt = 1;
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

      if (board[nx][ny] == 1 && !visited[nx][ny]) {
        cnt += dfs(nx, ny);
      }
    }

    return cnt;
  }
  
}
