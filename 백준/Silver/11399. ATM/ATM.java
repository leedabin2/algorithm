import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


class Main {
  static int N;
  static int answer = 0;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());

      String[] st = br.readLine().split(" ");

      int[] waiting = new int[N];
      PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> a[0] - b[0]
      );
      // time, idx

      for (int i = 0; i < N; i++) {
        waiting[i] = Integer.parseInt(st[i]);
        pq.add(new int[]{Integer.parseInt(st[i]), i});
      }

      List<Integer> wait = new ArrayList<>();

      while (!pq.isEmpty()) {

        int[] curr = pq.poll();
        int t = curr[0], idx = curr[1];
        
        wait.add(waiting[idx]);

        for (int time : wait) {
          answer += time;
        }
      }

      System.out.println(answer);





   }
}