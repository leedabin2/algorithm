import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int S = Integer.parseInt(st[1]);

    int[] numbers = new int[N];
    String[] row = br.readLine().split(" ");
    for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(row[i]);


    int minLength = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;
    
    for (int right = 0; right < N; right++) {
      sum += numbers[right];

      while(sum >= S) {
        minLength = Math.min(minLength, right-left+1);
        sum -= numbers[left++];
      }

    }

    System.out.print(minLength == Integer.MAX_VALUE ? 0 : minLength);
  }
} 