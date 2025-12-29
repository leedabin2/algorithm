import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      boolean[] wins = new boolean[N];
      int[][] score = new int[N][4];

      for (int i = 0; i < N; i++) {
         String[] row = br.readLine().split(" ");
         int idx = Integer.parseInt(row[0])-1;

         for (int j = 1; j < 5; j++) {
            score[idx][j-1] = Integer.parseInt(row[j]);
         }
      }

      StringBuilder sb = new StringBuilder();

      for (int j = 0; j < 4; j++) {
         int winner = -1;
         for (int i = 0; i < N; i++) {
            if (wins[i]) continue;
            if (winner == -1 ||
               score[i][j] > score[winner][j] ||
               (score[i][j] == score[winner][j] && i < winner)
            ) {
               winner = i;
            }
         }
         if (winner == -1) break;

         // 상을 받음
         wins[winner] = true;
         sb.append(winner+1).append(" ");
      }

      System.out.println(sb.toString().trim());
   }
}