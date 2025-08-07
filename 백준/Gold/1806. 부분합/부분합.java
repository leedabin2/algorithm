import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int S = Integer.parseInt(st[1]);

    String[] input = br.readLine().split(" ");

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);

    int start = 0;
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    for (int end = 0; end < N; end++) {
      sum += arr[end];

      while(sum >= S) {
        minLen = Math.min(minLen, end - start + 1);
        sum -= arr[start];
        start++;
      }
    }

    System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);

  }
} 