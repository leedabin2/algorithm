import java.util.*;
import java.io.*;

class Main {
  static final int MAX = 100001;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
  

    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);

    int[] dist = new int[MAX];
    int[] ways = new int[MAX];
    Arrays.fill(dist,-1);
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(N);
    dist[N] = 0;
    ways[N] = 1;

    while(!queue.isEmpty()) {
      int now = queue.poll();

      for (int next : new int[]{now-1, now+1, now*2}) {
        if (next >=0 && next < MAX) {
          if (dist[next] == -1) {
          dist[next] = dist[now] + 1;
          ways[next] = ways[now];
          queue.add(next);
          } else if (dist[next] == dist[now] + 1) {
            ways[next] += ways[now];
          }

        }
       
      }
    }

    System.out.println(dist[K]);
    System.out.println(ways[K]);

  }
} 