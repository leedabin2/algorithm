import java.util.*;
import java.io.*;

class Main {
  static int N, E;
  static List<List<int[]>> graph = new ArrayList<>();
  static final int INF = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    E = Integer.parseInt(st[1]);

    for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

    for (int i = 0; i < E; i++) {
      String[] row = br.readLine().split(" ");

      int a = Integer.parseInt(row[0]);
      int b = Integer.parseInt(row[1]);
      int c = Integer.parseInt(row[2]);

      graph.get(a).add(new int[]{b,c});
      graph.get(b).add(new int[]{a,c});
    }

    String[] vt = br.readLine().split(" ");
    int v1 = Integer.parseInt(vt[0]);
    int v2 = Integer.parseInt(vt[1]);
    

    int[] distFrom1 = func(1);
    int[] distFromV1 = func(v1);
    int[] distFromV2 = func(v2);

    // 경로 1: 1 → v1 → v2 → N
    int path1 = safeAdd(safeAdd(distFrom1[v1], distFromV1[v2]), distFromV2[N]);

    // 경로 2: 1 → v2 → v1 → N
    int path2 = safeAdd(safeAdd(distFrom1[v2], distFromV2[v1]), distFromV1[N]);
   
    int result = Math.min(path1, path2);
    System.out.println(result >= INF ? -1 : result);

  }
  static int[] func(int start) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    int[] dist = new int[N+1];
    Arrays.fill(dist, INF);
    pq.add(new int[]{start,0});
    dist[start] = 0;

    while(!pq.isEmpty()) {
      int[] curr = pq.poll();
      int node = curr[0];
      int cost = curr[1];

      if (dist[node] < cost ) continue;

      for (int[] next : graph.get(node)) {
        int nextNode = next[0];
        int nextCost = next[1];

        if (dist[nextNode] > dist[node] + nextCost) {
          dist[nextNode] = dist[node] + nextCost;
          pq.add(new int[]{nextNode, nextCost});
        }
      }
    }

    return dist;

  }
  static int safeAdd(int a, int b) {
    return (a >= INF || b >= INF) ? INF : a+b;
  }

} 