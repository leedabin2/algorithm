import java.util.*;
import java.io.*;

class Main {
  static int k;
  static int[] result = new int[6];
  static int[] numbers;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    while(true) {
      String[] st = br.readLine().split(" ");
      k = Integer.parseInt(st[0]);

      if (k == 0) break;

      numbers = new int[k];

      for (int i = 0; i < k ; i++) {
        numbers[i] = Integer.parseInt(st[i+1]);
      }

      dfs(0, 0);
      sb.append("\n");
    }
    System.out.print(sb);
  }

  static void dfs(int depth, int start ) {
    if (depth == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
      
      return;
    }

    for (int i = start; i < k; i++) {
      result[depth] = numbers[i];
      dfs(depth + 1, i + 1);
    }


  }
} 