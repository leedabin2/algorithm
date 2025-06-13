import java.util.*;
import java.io.*;

class Main {
  static List<List<int[]>> graph = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int M = Integer.parseInt(st[1]);

  
    for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

    for (int i = 0; i < M; i++) {
      String[] row = br.readLine().split(" ");
      int A = Integer.parseInt(row[0]);
      int B = Integer.parseInt(row[1]);

      graph.get(B).add(new int[]{A});
    }

    int max = 0;
    int[] answer = new int[N+1];

    for (int i = 1; i <= N; i++) { 
      boolean[] visited = new boolean[N+1];
      int c = bfs(i, visited);
      answer[i] = c;
      max = Math.max(max, c);
    }

    for (int i = 1; i <= N; i++) { 
      if (answer[i] == max) {
        System.out.print(i + " ");
      }
    }
      
  }
  

  private static int bfs(int st, boolean[] visited) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(st);
    visited[st] = true;
    int count = 1;

    while(!queue.isEmpty()) {
      int curr = queue.poll();

      for (int[] next : graph.get(curr)) {
        int nx = next[0];
        if (!visited[nx]) {
          visited[nx] = true;
          queue.add(nx);
          count++;
        }
      }
    }

    return count;

  }
}

