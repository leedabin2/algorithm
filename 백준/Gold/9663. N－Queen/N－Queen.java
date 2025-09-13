import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] board;
    static int answer = 0;
    static int[][] directions = new int[][]{{-1,0}, {1, 0}, {0,1}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        dfs(0);
        System.out.print(answer);
    }
    private static void dfs(int row) {
      if (row == N) {
        answer++;
        return;
      }

      for (int col = 0; col < N; col++) {
        if (canPlace(row, col)) {
          board[row][col] = 1;
          dfs(row+1);
          board[row][col] = 0;
        }
      }
    }
    private static boolean canPlace(int x, int y) {
      // 같은 열에 있는지 확인
      for (int i = 1; x-i >= 0; i++) {
        if (board[x-i][y] == 1) return false;
      }

      // 위쪽 대각선에 있는지 확인 
      for (int i = 0 ; x-i >= 0 && y-i >= 0; i++) {
        if (board[x-i][y-i] == 1) return false;
      }

      // 오른쪽 대각선에 있는지 확인
      for (int i = 0 ; x-i >= 0 && y+i < N; i++) {
        if (board[x-i][y+i] == 1) return false;
      }

      return true;
    }
    
}