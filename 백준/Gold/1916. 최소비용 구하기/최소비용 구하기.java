import java.util.*;
import java.io.*;

class Main {
  static final int INF = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[] dist = new int[N+1];
    Arrays.fill(dist,INF);

    List<List<int[]>> graph = new ArrayList<>();
    for (int i=0; i <= N; i++) graph.add(new ArrayList<>());

    for (int i =0;i < M; i++) {
      String[] row = br.readLine().split(" ");

      int a = Integer.parseInt(row[0]);
      int b = Integer.parseInt(row[1]);
      int c = Integer.parseInt(row[2]);

      graph.get(a).add(new int[]{b,c});
    }

    String[] info = br.readLine().split(" ");
    int start = Integer.parseInt(info[0]);
    int arrive = Integer.parseInt(info[1]);

    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    queue.add(new int[]{start,0});
    dist[start] = 0;

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();
      int now = curr[0];
      int cost = curr[1];
        
      if (dist[now] < cost) continue;

      for (int[] next : graph.get(now)) {
        int nextNode = next[0];
        int nextCost = next[1];

        int newCost = cost + nextCost;
        if (dist[nextNode] > newCost) {
          dist[nextNode] = newCost;
          queue.add(new int[]{nextNode,newCost});
        }
      }
    }

    System.out.print(dist[arrive]);
  }


} 