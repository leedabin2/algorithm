import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0;

    int N = Integer.parseInt(br.readLine());
    long[] A = new long[N];
    String[] st = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      A[i] = Long.parseLong(st[i]);
    }

    Arrays.sort(A);

    for (int i = 0; i < N; i++) {
      int left = 0;
      int right = N-1;
      long cur = A[i];

      while (left < right) {
        if (left == i){
          left++;
          continue;
        }
        if (right == i) {
          right--;
          continue;
        }

        long sum = A[left] + A[right];
        if (sum == cur) {
          answer++;
          break;
        }
        else if (sum > cur) {
          right--;
        } else {
          left++;
        }
      }

    }
    System.out.println(answer);

   }
}