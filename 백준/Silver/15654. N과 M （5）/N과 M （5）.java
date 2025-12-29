import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static int[] numbers;
  static boolean[] visited;
  static int[] result;
  static StringBuilder sb = new StringBuilder();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);

      String[] line = br.readLine().split(" ");
      numbers = new int[N];
      for (int i = 0; i < N; i++) {
        numbers[i] = Integer.parseInt(line[i]);
      }

      Arrays.sort(numbers);

      visited = new boolean[N];
      result = new int[M];

      dfs(0);

      System.out.println(sb);
   }
   static void dfs(int depth) {
    if (depth == M) {
      for (int i =0; i < M; i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        result[depth] = numbers[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }


   }
}