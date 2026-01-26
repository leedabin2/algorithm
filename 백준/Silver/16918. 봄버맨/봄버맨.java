import java.io.*;
import java.util.*;


class Main {
  static int R, C, N;
  static int[][] board;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      R = Integer.parseInt(st[0]);
      C= Integer.parseInt(st[1]);
      N = Integer.parseInt(st[2]);

      board = new int[R][C];

      for (int i = 0; i <R; i++) {
        String row = br.readLine();
        for (int j = 0; j < C; j++) {
          if (row.charAt(j) == '.') {
            board[i][j] = -1;
          }
        }
      }
      int time = 1;
      while (time < N) {
        
        time++;
        if (time % 2 == 0) {
          installBombs(time); // 해당 초에 폭탄 설치
        } else {
          explode(time - 3); // 3초전에 설치한 폭탄 제거
        }
      }

      printBoard();

   }
   static void installBombs(int time) {
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (board[i][j] == -1) board[i][j] = time;
      }
    }
   }
   static void explode(int installTime) {
    if (installTime < 0) return;
    boolean[][] boom = new boolean[R][C];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (board[i][j] == installTime) {
          boom[i][j] = true;
          for (int d = 0; d < 4; d++) {
            int nx = dx[d] + i; 
            int ny = dy[d] + j;
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            boom[nx][ny] = true;
          }
        }
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (boom[i][j]) board[i][j] = -1; // 폭발
      }
    }
   }

   static void printBoard() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (board[i][j] == -1) {
          sb.append('.');
        } else {
          sb.append('O');
        }
      }
      sb.append('\n');
    }

    System.out.println(sb.toString());
   }
  
 
  
}
