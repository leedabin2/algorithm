import java.util.*;
import java.io.*;

class Main {
  static int N, M, max;
  static int[][] board;
  static boolean[][] visited;
  static int[][] directions;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    board = new int[N][M];

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    max = 0;
    visited = new boolean[N][M];
    directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    for (int i =0; i <N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = true;
        dfs(i, j, board[i][j],1);
        visited[i][j] = false;
        checkCenterShapes(i,j);
      }
    }

    System.out.print(max);
    
  }
  static void dfs(int x, int y,int sum, int depth) {
    if (depth == 4) {
      max = Math.max(max,sum);
      return;
    }
    
    for (int[] dir : directions) {
      int nx = dir[0] + x;
      int ny = dir[1] + y;

      if (0<=nx && nx < N && 0 <= ny && ny < M ) {
        if (!visited[nx][ny]) {
          visited[nx][ny] = true;
          dfs(nx,ny,board[nx][ny] + sum, depth + 1);
          visited[nx][ny] = false;
        }
      }
    }

  }

  static void checkCenterShapes(int x,int y) {
    int[][][] shapes = new int[][][]{
      {{0,0},{-1,0},{0,-1},{0,1}},
      {{0,0},{1,0},{0,-1},{0,1}},
      {{0,0},{0,-1},{-1,0},{1,0}},
      {{0,0},{0,1},{-1,0},{1,0}},
    };

    for (int[][] shape : shapes) {
      boolean valid = true;
      int total = 0;

      for (int[] d: shape) {
        int nx = x + d[0], ny = y + d[1];
        if (0<=nx && nx < N && 0<= ny && ny < M) {
          total += board[nx][ny];
        } else {
          valid = false;
          break;
        }
      }

      if (valid) max = Math.max(max,total);
    }
  
  }
}