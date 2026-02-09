import java.io.*;
import java.util.*;

class Main {
  static int N, K;
  static int[] A;
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    K =Integer.parseInt(st[1]);

    A = new int[N];

    String[] row = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(row[i]);
    }

    
    Map<Integer, Integer> map = new HashMap<>();

    int answer = 0;
    int left = 0;
    
    for (int right =  0; right < N; right++) {
      map.put(A[right], map.getOrDefault(A[right], 0) + 1);

      while (map.get(A[right]) > K) {
        map.put(A[left], map.get(A[left]) - 1);
        left++;
      }

      answer = Math.max(answer, right - left + 1);
    }

    System.out.println(answer);
   }
}