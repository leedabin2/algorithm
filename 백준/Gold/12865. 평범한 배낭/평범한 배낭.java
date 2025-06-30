import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);

    int[] dp = new int[K+1];

    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split(" ");

      int W = Integer.parseInt(row[0]);
      int V = Integer.parseInt(row[1]);

      for (int w = K; w >= W; w--) {
        dp[w] = Math.max(dp[w], dp[w-W] + V);
      }
    }


    System.out.println(dp[K]);

  }
} 