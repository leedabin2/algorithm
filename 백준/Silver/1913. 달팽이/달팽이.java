import java.util.*;
import java.io.*;

class Main {
    static int[][] directions = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}}; // 위, 오, 아래, 왼
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int target = Integer.parseInt(br.readLine());
      // 위 + 1 , 우 +1, 하 +2, 왼 +2, 위+3,우+3, 하+4, 왼+4. 
      int[][] board = new int[n][n];

      int r = n / 2;
      int c = n / 2;
      int num = 1;
      board[r][c] = num;

      int step = 1;
      int dirIdx = 0;
      int targetR = r, targetC = c;

      while(num < n*n) {
        for (int t = 0; t < 2; t++) {
          for (int i = 0; i < step; i++) {
            if (num == n*n) break;
            r += directions[dirIdx][0];
            c += directions[dirIdx][1];

            num++;
            board[r][c] = num;

            if (num == target) {
              targetR = r;
              targetC = c;
            }
          }
          dirIdx = (dirIdx + 1) % 4;
        }
        step++;
      }

      StringBuilder sb = new StringBuilder();
      for (int i =0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          sb.append(board[i][j] + " ");
        }
        sb.append("\n");
      }
      sb.append((targetR+1) + " " + (targetC+1));
      System.out.println(sb);

    }
}