import java.io.*;
import java.util.*;

class Main {
  static List<List<Integer>> graph;
    static boolean[] visited;
    static int n, m;
    static int count = 0;


    public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    m = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      String[] st = br.readLine().split(" ");
      
      int a = Integer.parseInt(st[0]);
      int b = Integer.parseInt(st[1]);
      graph.get(a).add(b);
      graph.get(b).add(a);
  
    }
    visited = new boolean[n+1];

    dfs(1);

    System.out.println(count);
  }static void dfs(int node) {
    visited[node] = true;

    for (int next : graph.get(node)) {
      if (!visited[next]) {
        count++;
        dfs(next);
      }
    }
  }
}
