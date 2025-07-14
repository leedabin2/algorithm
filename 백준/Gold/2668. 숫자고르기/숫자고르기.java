import java.util.*;
import java.io.*;

class Main {
  static int[] a;
  static boolean[] visited;
  static Set<Integer> result = new HashSet<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    a = new int[N+1];
    for (int i = 1; i <= N; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    visited = new boolean[N+1];

    for (int i = 1; i <= N; i++) {
      dfs(i, new ArrayList<>());
    }
    
    List<Integer> ans = new ArrayList<>(result);
    Collections.sort(ans);

    System.out.println(ans.size());
    for (int num : ans) {
      System.out.println(num);
    }
  


  }
  static void dfs(int curr, List<Integer> path) {
    if (visited[curr]) {
      if (path.contains(curr)) {
        int idx = path.indexOf(curr);

        for (int i = idx; i < path.size(); i++) {
          result.add(path.get(i));
        }
      }
      return;
    }

    visited[curr] = true;
    path.add(curr); // 1, 3
    dfs(a[curr], path); 
    path.remove(path.size()-1);
  }
} 