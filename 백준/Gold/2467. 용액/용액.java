import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] liter = new int[N];
    String[] st = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      liter[i] = Integer.parseInt(st[i]);
    }
    Arrays.sort(liter);

    int left = 0;
    int right = N-1;

    int minSum = Integer.MAX_VALUE;
    int ansLeft = 0, ansRight = 0;

    while(left < right) {
      int sum = liter[left] + liter[right];

      if (Math.abs(sum) < minSum) {
        minSum = Math.abs(sum);
        ansLeft = liter[left];
        ansRight = liter[right];
      }

      if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }

    System.out.print(ansLeft + " " + ansRight);
  }
} 