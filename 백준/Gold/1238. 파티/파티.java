import java.util.*;
import java.io.*;

class Main {
  static final int INF = Integer.MAX_VALUE;
  static List<List<int[]>> graph = new ArrayList<>();
  static int N, M, X;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    X = Integer.parseInt(st[2]);

    for (int i =0; i <= N; i++) graph.add(new ArrayList<>());

    for (int i =0; i < M; i++) {
      String[] row = br.readLine().split(" ");
      int a = Integer.parseInt(row[0]);
      int b = Integer.parseInt(row[1]);
      int t = Integer.parseInt(row[2]);

      graph.get(a).add(new int[]{b,t});
    }

    int[] distToX = new int[N+1]; // 시작 -> X
    int[] distFromX = func(X); // X -> 모든마을
    int max = 0;
    for (int i = 1; i <= N; i++) {
      if (i == X) continue;
      distToX = func(i); // i -> X
      int roundTrip = distToX[X] + distFromX[i];

      max = Math.max(max,roundTrip);
    }

    System.out.println(max);
  }

  static int[] func(int start) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.add(new int[]{start,0});

    int[] dist = new int[N+1];
    Arrays.fill(dist,INF);
    dist[start] = 0;

    while(!pq.isEmpty()) {
      int[] curr = pq.poll();

      int node = curr[0];
      int time = curr[1];

      if (dist[node]  < time) continue;

      for (int[] next : graph.get(node)) {
        int nextNode = next[0];
        int nextTime = next[1];

        if (dist[nextNode] > dist[node] + nextTime) {
          dist[nextNode] = dist[node] + nextTime;
          pq.add(new int[]{nextNode, dist[node] + nextTime});
        }
      }
    }


    return dist;
  }
} 