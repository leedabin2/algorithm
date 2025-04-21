import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] st = br.readLine().split(" ");

        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        board = new char[N][M];
        for (int i =0; i < N; i++) {
          String line = br.readLine();
          for (int j = 0; j < M; j++) {
            board[i][j] = line.charAt(j);
          }
        }

        int minRes = 50*50;

        for (int i = 0; i < N-7; i++) {
          for (int j = 0; j < M-7; j++) {
            minRes = Math.min(minRes, ches(i,j));
          }
        }
        sb.append(minRes);
        System.out.print(sb);
    }

    private static int ches(int x, int y) {
      int wStart = 0;
      int bStart = 0;

      for (int i = 0; i < 8 ; i++) {
        for (int j =0 ; j < 8; j++) {
          char cur = board[x+i][y+j];
          if ((i+j) % 2 == 0) {
            if (cur != 'W') {
                wStart++;
            }
            if (cur != 'B') {
                bStart++;
            }
          }
          else {
            if (cur != 'W') {
                bStart++;
            }
            if (cur != 'B') {
                wStart++;
            }
          }
        }
      }
      return Math.min(wStart,bStart);
    }

  
}
