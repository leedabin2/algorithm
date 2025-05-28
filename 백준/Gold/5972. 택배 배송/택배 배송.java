import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static List<List<int[]>> graph = new ArrayList<>();
  static int[] dist;
  static final int INF = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    for (int i =0; i < N+1; i++) graph.add(new ArrayList<>());

    for (int i = 0; i < M; i++) {
      String[] row = br.readLine().split(" ");

      int a = Integer.parseInt(row[0]);
      int b = Integer.parseInt(row[1]);
      int c = Integer.parseInt(row[2]);

      graph.get(a).add(new int[]{b,c});
      graph.get(b).add(new int[]{a,c});
    }
    
    dist = new int[N+1];
    Arrays.fill(dist,INF);

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    queue.add(new int[]{1,0}); // 정점, 비용
    dist[1] = 0;
  
    while(!queue.isEmpty()) {
      int[] curr = queue.poll();

      int currNode = curr[0];
      int currCost = curr[1];


      for (int[] next : graph.get(currNode)) {
        int nextNode = next[0];
        int nextEdgeCost = next[1];

        int newCost = currCost + nextEdgeCost;

        if (dist[nextNode] > newCost) {
          dist[nextNode] = newCost;
          queue.add(new int[]{nextNode,newCost});
        }
      }
    }

    System.out.println(dist[N]);


  }
} 