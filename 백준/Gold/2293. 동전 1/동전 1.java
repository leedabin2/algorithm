import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    
    String[] st = br.readLine().split(" ");

    int n = Integer.parseInt(st[0]);
    int k = Integer.parseInt(st[1]);
    
    int[] coins = new int[n];
    for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());

    int[] dp = new int[k+1];
    dp[0] = 1;

    // 1 2 5
  
    for (int coin : coins) {
      for (int i = coin; i <= k; i++) {
        dp[i] += dp[i - coin];
      }
    }

    System.out.print(dp[k]);
  }
} 