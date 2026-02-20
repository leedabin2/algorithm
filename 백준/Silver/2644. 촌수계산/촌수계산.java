import java.io.*;
import java.util.*;

class Main {
  static int n, m, a, b;
  static List<List<Integer>> graph;
  static boolean[] visited;
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    String[] st = br.readLine().split(" ");
    a = Integer.parseInt(st[0]);
    b = Integer.parseInt(st[1]);

    m = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();
    for (int i = 0 ; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      String[] info = br.readLine().split(" ");

      int x = Integer.parseInt(info[0]); // 부모
      int y = Integer.parseInt(info[1]); // 자식

      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    visited = new boolean[n+1];

    System.out.println(bfs(a, 0));


  }
  static int bfs(int start, int cnt) {
    Deque<int[]> queue = new ArrayDeque<>();
    visited[start] = true;
    queue.add(new int[]{start, cnt});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      int node = cur[0];
      int dist = cur[1];
      if (node == b) return dist;

      for (int next : graph.get(node)) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(new int[]{next, dist+1});
        }
      }
      
    }

    return -1;
  }
   
}