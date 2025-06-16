import java.util.*;
import java.io.*;

class Main {
  static int max = 0;
  static String[] board;
  static int N, M;
  static int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
  static boolean[] visited = new boolean[26];
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    board = new String[N];

    for (int i = 0; i < N; i++) {
      String row = br.readLine();

      board[i] = row;
    }

    visited[board[0].charAt(0) - 'A'] = true;
    dfs(0,0, 1);
    System.out.print(max);
  }

  static void dfs(int x, int y, int cnt) {
    max = Math.max(max, cnt);

    for (int[] dir : directions) {
      int nx = dir[0] + x;
      int ny = dir[1] + y;

      if (0<= nx && nx < N && 0 <= ny && ny < M) {
        if (!visited[board[nx].charAt(ny) - 'A']) {
          visited[board[nx].charAt(ny) - 'A'] = true;
          dfs(nx, ny, cnt+1);
          visited[board[nx].charAt(ny) - 'A']  = false;
        }
      }
    }
  }


} 