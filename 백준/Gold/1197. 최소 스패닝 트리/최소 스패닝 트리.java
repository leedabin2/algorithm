import java.io.*;
import java.util.*;

class Main  {
    static int V, E;
    static List<List<int[]>> graph;
    static PriorityQueue<int[]> pq;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] st = br.readLine().split(" ");
        
        V = Integer.parseInt(st[0]);
        E = Integer.parseInt(st[1]);
        
        graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
          graph.add(new ArrayList<>());
        }
        visited = new boolean[V];
        
        // {cost, to} cost 오름차순
        pq = new PriorityQueue<>(
          (a, b) -> Integer.compare(a[0], b[0])
        );
        
        for (int i = 0; i < E; i++) {
          String[] row = br.readLine().split(" ");

          int a = Integer.parseInt(row[0]) -1;
          int b = Integer.parseInt(row[1]) -1;
          int c = Integer.parseInt(row[2]);

          graph.get(a).add(new int[]{b, c});
          graph.get(b).add(new int[]{a, c});
        }

        pq.add(new int[]{0, 0});
        
        calc();
    }
    static void calc() {
      int total = 0;
      while (!pq.isEmpty()) {

        int[] curr = pq.poll();

        int cost = curr[0];
        int to = curr[1];

        if (visited[to]) continue;
        visited[to] = true;
        total += cost;

        for (int[] next : graph.get(to)) {
          int nextTo = next[0];
          int nextCost = next[1];

          if (!visited[nextTo]) {
            pq.add(new int[]{nextCost, nextTo});
          }
        }
        
      }

      System.out.println(total);
    }



}