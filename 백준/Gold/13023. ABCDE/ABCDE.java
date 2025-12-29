import java.io.*;
import java.util.*;
class Main {
  static int N, M;
  static List<List<Integer>> graph;
  static boolean[] visited;
  static boolean found = false;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);

      graph = new ArrayList<>();
      
      for (int i = 0; i < N; i++) {
        graph.add(new ArrayList<>());
      }
      for (int i = 0; i < M; i++) {
        String[] line = br.readLine().split(" ");

        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);

        graph.get(a).add(b);
        graph.get(b).add(a);
      }


      visited = new boolean[N];

      // 사이클이 없어야 친구 관계 성립
      for (int i = 0; i < N; i++) {
        dfs(i, 0);
        if (found) {
          System.out.println(1);
          return;
        }
      }

      System.out.println(0);
      
   }
   static void dfs(int now, int depth) {
    if (depth == 4) {
      found = true;
      return;
    }

    visited[now] = true;

    for (int next : graph.get(now)) {
      if (!visited[next]) {
        dfs(next, depth + 1);
        if (found) return;
      }
    }

    visited[now] = false;
   }
}