import java.io.*;
import java.util.*;

class Main {
  static final int N = 9;
  static int[][] board;
  static boolean isFound = false;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      board = new int[N][N];
      List<int[]> blanks = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          board[i][j] = Integer.parseInt(row[j]);
          if (board[i][j] == 0) blanks.add(new int[]{i, j});
        }
      }

      dfs(0, blanks);
   }
   static void dfs(int depth, List<int[]> blanks) {
    if (isFound) return;

    if (depth == blanks.size()) {
      printBoard();
      isFound = true;
      return;
    }

    int x = blanks.get(depth)[0];
    int y = blanks.get(depth)[1];

    for (int i = 1; i <= 9; i++) {
      if (check(i, x, y)) {
        board[x][y] = i;
        dfs(depth + 1, blanks);
        board[x][y] = 0;
      }
    }
   }

   static boolean check(int num, int x, int y ) {
    // 가로, 세로 체크
    for (int i = 0; i < N; i++) {
      if (board[x][i] == num) return false;
      if (board[i][y] == num) return false;
    }

    // 3 * 3
    int sx = (x / 3) * 3;
    int sy = (y / 3) * 3;
    // 0, 1, 2 -> 0
    // 3, 4, 5 -> 3
    // 6, 7, 8 -> 6
    for (int i = sx; i < sx+3; i++) {
      for (int j = sy; j < sy+3; j++) {
        if (board[i][j] == num) return false;
      }
    }


    return true;
   }

   static void printBoard() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(board[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
   }
}