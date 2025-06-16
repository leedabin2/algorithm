import java.util.*;
import java.io.*;

class Main {
  static final int N = 10;
  static int[][] board;
  static int min = Integer.MAX_VALUE;
  static int[] papers = {0,5,5,5,5,5};
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    board = new int[N][N];

    for (int i = 0 ; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    dfs(0,0,0);
    System.out.println(min == Integer.MAX_VALUE ? -1 : min);
  }

  static void dfs(int x, int y, int used) {

    if (x >= N) {
      min = Math.min(min, used);
      return;
    }

    if (y >= N) {
      dfs(x+1, 0, used);
      return;
    }

    if (board[x][y] == 0) {
      dfs(x, y+1, used);
      return;
    }
    


    for (int size = 5; size >= 1; size--) {
      if (canAttach(x, y, size) && papers[size] >0) {
        attach(x, y, size, 0);
        papers[size]--;
        dfs(x, y+1, used+1);
        attach(x,y,size,1);
        papers[size]++;

      }
    }
  
  }
  static boolean canAttach(int x, int y, int size) {

    if (x + size > N || y + size > N) return false;
    for (int i = x ; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (board[i][j] == 0) return false;
      }
    }
    return true;  
  }

  static void attach(int x, int y, int size, int used) {
    for (int i = x ; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        board[i][j] = used;
      }
    }
  }



} 