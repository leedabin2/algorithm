import java.util.*;
import java.io.*;

class Main {
  static int N, S, count = 0;
  static int[] numbers;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    S = Integer.parseInt(st[1]);

    String[] row = br.readLine().split(" ");
    numbers = new int[N];
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(row[i]);
    }

    dfs(0, 0);

    if (S == 0) count--;
    System.out.println(count);

  }

  static void dfs(int depth, int sum) {
    if (depth == N) {
      if (sum == S) count++;
      return;
    }

    dfs(depth + 1, sum + numbers[depth]);

    dfs(depth + 1, sum);
  }
} 