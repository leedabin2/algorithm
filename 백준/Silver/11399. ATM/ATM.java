import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int answer = 0;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());

      String[] st = br.readLine().split(" ");

      int[] waiting = new int[N];

      for (int i = 0; i < N; i++) {
        waiting[i] = Integer.parseInt(st[i]);
      }

      Arrays.sort(waiting);

      int sum = 0;

      for (int time : waiting) {
        sum += time;
        answer += sum;
      }

      System.out.println(answer);





   }
}