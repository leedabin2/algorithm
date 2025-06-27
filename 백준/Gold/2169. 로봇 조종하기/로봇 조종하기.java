import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int N = Integer.parseInt(st[0]);
    int M = Integer.parseInt(st[1]);

    int[][] board = new int[N][M];

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j =0; j < M; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    int[][] dp = new int[N][M];
    
    dp[0][0] = board[0][0];
    // 첫줄은 오른 쪽으로만 진행
    for (int j = 1; j < M; j++) {
      dp[0][j] = dp[0][j-1] + board[0][j];
    }

    for (int i = 1; i < N; i++) {
      int[] leftToRight = new int[M]; 
      int[] RightToLeft = new int[M];

      // 왼 -> 오
      leftToRight[0] = dp[i-1][0] + board[i][0];
      for (int j = 1; j < M; j++) {
        leftToRight[j] = Math.max(dp[i-1][j],leftToRight[j-1]) + board[i][j];
      }

      // 오 -> 왼
      RightToLeft[M-1] = dp[i-1][M-1] + board[i][M-1];
      for (int j = M-2 ; j >= 0; j--) {
        RightToLeft[j] = Math.max(dp[i-1][j], RightToLeft[j+1]) + board[i][j];
      }

      // 합치기
      for (int j = 0; j < M; j++) {
        dp[i][j] = Math.max(leftToRight[j], RightToLeft[j]);
      }      
    }
    System.out.print(dp[N-1][M-1]);
  }
} 