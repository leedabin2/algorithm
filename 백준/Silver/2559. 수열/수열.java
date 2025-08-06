import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int answer = Integer.MIN_VALUE;

    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);
    int[] arr = new int[N];
    String[] input = br.readLine().split(" ");
    for (int i =0;i < N; i++) arr[i] = Integer.parseInt(input[i]);
    for (int i =0; i < N; i++) {
      int idx = i;
      int sum = 0;
      if (i + K > N) break;
      while(idx < N && idx < i + K ) {
        sum += arr[idx];
        idx++;
      }

      answer = Math.max(sum, answer);
    }

    System.out.println(answer);
  }
} 