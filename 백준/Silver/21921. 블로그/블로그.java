import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int X = Integer.parseInt(st[1]);

    int[] graph = new int[N];
    String[] row = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      graph[i] = Integer.parseInt(row[i]);
    }

    int sum = 0;
    for (int i =0 ; i < X; i++) sum += graph[i];

    int max = sum;
    int count = 1;
    for (int i = X; i < N; i++) {
      sum = sum - graph[i-X] + graph[i];

      if (max < sum) {
        max = sum;
        count = 1;
      } else if (max == sum) {
        count++;
      }
    }

    if (max == 0) {
      System.out.println("SAD");
    } else {
      System.out.println(max);
      System.out.println(count);

    }

  }
}