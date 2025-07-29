import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    Map<Integer, List<int[]>> graph  = new HashMap<>();

    String[] st = br.readLine().split(" ");
    int V = Integer.parseInt(st[0]);
    int E = Integer.parseInt(st[1]);

    for (int i = 1; i <= V; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int i =0 ; i < E; i++) {
      String[] row = br.readLine().split(" ");

      int a = Integer.parseInt(row[0]);
      int b = Integer.parseInt(row[1]);
      int c = Integer.parseInt(row[2]);

      graph.get(a).add(new int[]{b, c});
      graph.get(b).add(new int[]{a, c});
    }

    boolean[] visited = new boolean[V+1];

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.add(new int[]{0,1}); // cost, to

    int total = 0;
    int visitedCount = 0;
    while(!pq.isEmpty()) {
      int[] curr = pq.poll();
      int cost = curr[0];
      int to = curr[1];

      if (visited[to]) continue;
      visited[to] = true;
      total += cost;
      visitedCount++;

      if (visitedCount == V) break;
      
      for (int[] next : graph.get(to)) {
        int nextCost = next[1];
        int nextTo  = next[0];

        if (!visited[nextTo]) {
          pq.add(new int[]{nextCost, nextTo});
        }
      }
    }

    System.out.println(total);


  }
} 