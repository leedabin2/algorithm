import java.io.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());

      String[] st = br.readLine().split(" ");

      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st[i]);
      }

      int[] dp = new int[n];
      dp[0] = arr[0];
      int answer = dp[0];

      for (int i = 1; i < n; i++) {
        dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        answer = Math.max(answer, dp[i]);
      }

      System.out.println(answer);
   }
}