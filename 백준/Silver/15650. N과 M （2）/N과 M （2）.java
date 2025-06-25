import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static int[] result;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    result = new int[M];
    dfs(0, 1);
  }

  static void dfs(int depth, int start) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(result[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i <= N; i++) {
      result[depth] = i; 
      dfs(depth + 1, i + 1);
    }
  }

} 