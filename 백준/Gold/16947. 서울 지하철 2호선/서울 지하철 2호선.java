import java.util.*;
import java.io.*;

class Main {
  static int N;
  static boolean[] visited, cycle;
  static List<List<Integer>> graph;
  static int[] dist;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i =0; i < N;i++) {
      String[] info = br.readLine().split(" ");

      int a = Integer.parseInt(info[0]);
      int b = Integer.parseInt(info[1]);

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    visited = new boolean[N+1];
    cycle = new boolean[N+1];
    dist = new int[N+1];
    Arrays.fill(dist,-1);

    checkCycle(1, 0); // 순환선인지체크

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      if (cycle[i]) {
        dist[i] = 0;
        queue.add(i);
      }
    }

    while(!queue.isEmpty()) {
      int curr = queue.poll();
      for (int next: graph.get(curr)) {
        if (dist[next] == -1) {
          dist[next] = dist[curr] + 1;
          queue.add(next);
        }
      }
    }

    for (int i =1; i <= N; i++) {
      System.out.print(dist[i] + " ");
    }
    
  }

  static int checkCycle(int curr, int prev) {
    visited[curr] = true;
    for (int next: graph.get(curr)) {
      if (next == prev) continue;
      if (!visited[next]) {
        int res = checkCycle(next, curr);
        if (res == -2) return -2;
        if (res >= 0) {
          cycle[curr] = true;
          if (curr == res) return -2;
          else return res;
        }
      } else {
        cycle[curr] = true;
        return next;
      }
    }
    return -1;


  
  }
} 