import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    String[] st = br.readLine().split(" ");
    int K = Integer.parseInt(st[0]);
    int N = Integer.parseInt(st[1]);

    long answer = 0;

    int[] length = new int[K];

    for (int i = 0; i < K; i++) {
      length[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(length);

    long left = 1;
    long right = length[K-1];

    while (left <= right) {
      long mid = (left + right) / 2;

      long cnt = 0;

      for (int i = 0; i < K; i++) {
        cnt += length[i] / mid;
      }

      if (cnt >= N) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1; 
      }
      
    }
    System.out.println(answer);
   }
}