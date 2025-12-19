import java.io.*;

class Main {
  static int answer;
  static int N;
  static int[][] day;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());

      day = new int[N][2];

      for (int i = 0; i < N; i++) {
        String[] st = br.readLine().split(" ");

        int t = Integer.parseInt(st[0]);
        int p = Integer.parseInt(st[1]);

        day[i][0] = t;
        day[i][1] = p;
      }

      int[] dp = new int[N+1];
      for (int i = 0; i < N; i++) {
        int end = i + day[i][0];

        // 상담을 하지 않는 경우
        dp[i+1] = Math.max(dp[i+1], dp[i]);

        // 상담을 하는 경우
        if (end <= N) {
          dp[end] = Math.max(dp[end], day[i][1] + dp[i]);
        }
      }

      System.out.println(dp[N]);

   }

}