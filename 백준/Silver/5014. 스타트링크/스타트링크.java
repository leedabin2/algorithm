import java.util.*;
import java.io.*;

class Main {
  static final int INF = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int F = Integer.parseInt(st[0]);
    int S = Integer.parseInt(st[1]);
    int G = Integer.parseInt(st[2]);

    int[] button = new int[2];
    button[0] = Integer.parseInt(st[3]);
    button[1] = -Integer.parseInt(st[4]);

    int[] dist = new int[F+1];
    Arrays.fill(dist,INF);

    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(S); 
    dist[S] = 0;

    while(!queue.isEmpty()) {
      int curr = queue.poll();

      for (int move : button) {
        int next = curr + move;

        if (next >= 1 && next <= F && dist[next] == INF) {
          dist[next] = dist[curr] + 1;
          queue.add(next);
        }
      }

    }

    System.out.println(dist[G] == INF ? "use the stairs" : dist[G]);
  }
} 