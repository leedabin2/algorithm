import java.util.*;
import java.io.*;

class Main {
  static int[][] board = new int[9][9];
  static List<int[]> blanks = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 9; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0 ; j < 9; j++) {
        board[i][j] = Integer.parseInt(st[j]);
        if (board[i][j] == 0) blanks.add(new int[]{i,j});
      }
    }

    sudoku(0);
  }
  static void sudoku(int depth) {
    if (depth == blanks.size()) {
      printBoard();
      System.exit(0);
    }

    int x = blanks.get(depth)[0];
    int y = blanks.get(depth)[1];

    for (int i = 1; i <= 9; i++) {
      if (isValid(x, y, i)) {
        board[x][y] = i;
        sudoku(depth + 1);
        board[x][y] = 0;
      }
    }
    
  }

  static boolean isValid(int x, int y, int num) {
    // 가로 세로
    for (int i = 0; i < 9; i++) {
      if (board[x][i] == num || board[i][y] == num) return false;
    }
    
    // 3 * 3
    int sx = (x / 3) * 3;
    int sy = (y / 3) * 3;
    for (int i = sx; i < sx + 3; i++) {
      for (int j = sy; j < sy + 3; j++) {
        if (board[i][j] == num) return false;
      }
    }

    return true;
  }

  static void printBoard() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0 ; j < 9; j++) {
          System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
} 