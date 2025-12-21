import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      String[] st = br.readLine().split(" ");
      int[] a = new int[N];

      for (int i =0; i < N; i++) {
        a[i] = Integer.parseInt(st[i]);
      }

      int[] dp = new int[N];
      Arrays.fill(dp, 1);
      int answer = dp[0];

      for (int i = 1; i < N; i++) {
        for (int j = 0; j < i; j++) {
          if (a[i] > a[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
          }
        }
        answer = Math.max(answer, dp[i]);
      }

      System.out.println(answer);

   }
}