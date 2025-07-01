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

    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(N);
    dist[N] = 1;

    while(!queue.isEmpty()) {
      int curr = queue.poll();

      if (curr == K) {
        System.out.print(dist[K] - 1);
        break;
      }

      int[] nexts = new int[]{curr * 2, curr - 1, curr + 1};

      for (int i = 0; i < 3; i++) {
        int next = nexts[i];

        if (next >= 0 && next <= 100000 && dist[next] == 0) {
          if (i == 0) {
            queue.addFirst(next);
            dist[next] = dist[curr] + 1;
          }else {
            queue.addLast(next);
            dist[next] = dist[curr] + 1;
          }
        }
      }
    }
  }
 
} 