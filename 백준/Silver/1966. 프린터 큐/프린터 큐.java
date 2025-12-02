import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int T = Integer.parseInt(br.readLine());

      while (T-- > 0) {

        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);
        int find = Integer.parseInt(st[1]);

        int[] pri = new int[N];
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; i++) pri[i] = Integer.parseInt(in[i]);
        
        // 우선순위 내림차순 정렬 
        int[] sorted = pri.clone();
        Arrays.sort(sorted);
        int maxIdx = N-1;

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
          q.add(new int[]{i, pri[i]}); // idx, priority
        }

        int out = 0; 
        while (!q.isEmpty()) {
          int[] curr = q.poll();

          int idx = curr[0];
          int num = curr[1];

          if (num != sorted[maxIdx]) { // 최고 우선 순위가 아니면 뒤로
            q.addLast(curr);
            continue; 
          }

          out++;
          if (find == idx) {
            System.out.println(out);
            break;
          }

          maxIdx--;
        }
      }

   }
}