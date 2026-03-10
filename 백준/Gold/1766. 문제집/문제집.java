import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int N = Integer.parseInt(st[0]);
    int M = Integer.parseInt(st[1]);

    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
        graph.add(new ArrayList<>());
    }

    int[] indegree = new int[N+1];
    for (int i = 0; i < M; i++) {
      String[] info = br.readLine().split(" ");
      int A = Integer.parseInt(info[0]);
      int B = Integer.parseInt(info[1]);

      graph.get(A).add(B);
      indegree[B]++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        pq.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      int cur = pq.poll();

      sb.append(cur).append(" ");

      for (int next : graph.get(cur)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          pq.add(next);
        }
      }
      
    }

    System.out.println(sb);

   }
}