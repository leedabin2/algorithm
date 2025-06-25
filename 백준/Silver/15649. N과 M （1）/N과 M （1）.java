import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static int[] result;
  static boolean[] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    result = new int[M];
    visited = new boolean[N + 1];

    dfs(0);
  }

  static void dfs(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        System.out.print(result[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[depth] = i;
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }
} 