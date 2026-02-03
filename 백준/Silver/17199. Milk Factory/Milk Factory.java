import java.io.*;
import java.util.*;

class Main {
  static int N;
  static boolean[] visited;
  static List<List<Integer>> stages = new ArrayList<>();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());

      for (int i = 0; i <= N; i++) {
        stages.add(new ArrayList<>());
      }

      for (int i =0; i < N-1; i++) {
        String[] row = br.readLine().split(" ");
        int a = Integer.parseInt(row[0]);
        int b = Integer.parseInt(row[1]);

        stages.get(b).add(a); // 역방향
      }

      // 2 -> 1, 3 
      for (int i = 1; i <= N; i++) {
        visited = new boolean[N+1];
        dfs(i);

        boolean ok = true;

        for (int j = 1; j <= N; j++) {
          if (!visited[j]) {
            ok = false;
            break;
          }
        }
        if (ok) {
          System.out.println(i);
          return;
        }
      }

      System.out.println(-1);
   }
   static void dfs(int node) {
    visited[node] = true;
    for (int next : stages.get(node)) {
      if (!visited[next]) {
        dfs(next);
      }
    }
   }

   
}