import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int M = Integer.parseInt(st[1]);

    List<List<Integer>> graph = new ArrayList<>();

    for (int i =0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      String[] num = br.readLine().split(" ");
      int a = Integer.parseInt(num[0]);
      int b = Integer.parseInt(num[1]);
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    int[] dist = new int[N+1];
    Arrays.fill(dist,-1);

   
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    dist[1] = 0;

    while(!queue.isEmpty()) {
      int now = queue.poll();

      for (int next : graph.get(now)) {
        if (dist[next] == -1) {
          dist[next] = dist[now] + 1;
          queue.add(next);
        }
      }
    }

    int count = 0;
    int far = 0;
    int num = 0;
    for (int i =0; i <= N; i++) {
      if (dist[i] > far) {
        far = dist[i];
        num = i;
        count = 1;
      }
      else if (far == dist[i]) {
        count++;
      }
    }

    System.out.println(num + " " + far + " " + count);

  }
} 