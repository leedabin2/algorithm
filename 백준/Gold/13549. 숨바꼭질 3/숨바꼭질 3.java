import java.util.*;
import java.io.*;

class Main {
  static int N, K, min;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    K = Integer.parseInt(st[1]);

    int[] dist = new int[100001];
    Arrays.fill(dist,-1);

    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(N);
    dist[N] = 1;

    while(!queue.isEmpty()) {
      int now = queue.poll();

      if (now == K) {
        System.out.print(dist[now]-1);
        return;
      }

      int next = now * 2;
      if (next < 100001 && dist[next] == -1) {
        dist[next] = dist[now];
        queue.addFirst(next);
      }

      next = now - 1;
      if (next >=0 && dist[next] == -1) {
        dist[next] = dist[now] + 1;
        queue.addLast(next);
      }

      next = now + 1;
      if (next < 100001 && dist[next] == -1) {
        dist[next] = dist[now] + 1;
        queue.addLast(next);
      }
    }
  }
 
} 