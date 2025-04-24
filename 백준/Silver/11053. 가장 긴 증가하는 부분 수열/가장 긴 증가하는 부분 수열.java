import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int[] lst = new int[A];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < A; i++) {
            lst[i] = Integer.parseInt(st[i]);
        }

        int[] dp = new int[A];
        Arrays.fill(dp, 1); 

        for (int i = 1; i < A; i++) {
          for (int j = 0; j < i; j++) {
            if (lst[j] < lst[i]) {
              dp[i] = Math.max(dp[i], dp[j]+1);
            }
          }
        }

        int max = 0;
        for (int n : dp) {
          if (n > max) {
            max = n;
          }
        }
        System.out.println(max);
    }
}
