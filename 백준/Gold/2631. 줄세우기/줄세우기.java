import java.util.*;
import java.io.*;

class Main {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    int[] children = new int[N];

    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine());
      children[i] = input;
    }

    int[] dp = new int[N];
    Arrays.fill(dp,1);

    int maxLen = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (children[j] < children[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    for (int i = 0; i < N; i++) {
      maxLen = Math.max(maxLen, dp[i]);
    }

    System.out.println(N - maxLen);

  }
} 