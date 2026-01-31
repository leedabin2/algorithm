import java.io.*;

class Main {
  static final int N = 5;
  static final int num = 25;
  static boolean[][] bingo = new boolean[N][N];
  static int[][] pos = new int[num+1][2];
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          int num = Integer.parseInt(row[j]);
          pos[num][0] = i;
          pos[num][1] = j;
        }
      }

      int cnt = 0;
      for (int i = 0; i < N; i++) {
        String[] cmd = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          int call = Integer.parseInt(cmd[j]);
          int x = pos[call][0];
          int y = pos[call][1];

          bingo[x][y] = true; // x 표시

          cnt++;
          if (cnt >= 12) { // 최소 빙고 횟수일때
            if (checkBingo() >= 3) {
              System.out.println(cnt);
              return;
            }
          }
        }
      }
   }
   static int checkBingo() {
      int total = 0;

      // 가로로 빙고인지 체크
      for (int i = 0; i < 5; i++) {
        boolean ok = true;
        for (int j = 0; j < 5; j++) {
          if (!bingo[i][j]) ok = false;
        }
        if (ok) total++;
      }

      // 세로로 빙고인지 체크
      for (int j = 0; j < 5; j++) {
        boolean ok = true;
        for (int i = 0; i < 5; i++) {
          if (!bingo[i][j]) ok = false;
        }
        if (ok) total++;
      }

      // 대각선 1 (좌측)
      boolean ok1 = true;
      for (int i =0; i < 5; i++) {
        if (!bingo[i][i]) ok1 = false;
      }
      if (ok1) total++;

      // 대각선 2 (우측)
      boolean ok2 = true;
      for (int i = 0; i < 5; i++) {
        if (!bingo[i][4-i]) ok2 = false;
      }
      if (ok2) total++;

      return total;
   }
}