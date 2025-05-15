import java.util.*;
import java.io.*;

class Main {
  static final int MAX_DIST = 1000;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int k = 0; k < t; k++) {
      int n = Integer.parseInt(br.readLine());

      List<int[]> dist = new ArrayList<>();
      for (int j =0; j < n+2; j++) {
        String[] st = br.readLine().split(" ");
        int x = Integer.parseInt(st[0]);
        int y = Integer.parseInt(st[1]);
        dist.add(new int[]{x,y});
      }

      Deque<Integer> queue = new ArrayDeque<>();
      queue.add(0);
      boolean[] visited = new boolean[n+2];
      visited[0] = true;

      while(!queue.isEmpty()) {
        int currIdx = queue.poll();
        int[] curr = dist.get(currIdx);

        for (int i = 0; i < n+2; i++) {
          if (!visited[i]) {
            int[] next = dist.get(i);
            int d = Math.abs(next[0]-curr[0]) + Math.abs(next[1]-curr[1]);
            if (d <= MAX_DIST) {
              visited[i] = true;
              queue.add(i);
            }
          }
        }
      }

      System.out.println(visited[n+1] ? "happy" : "sad");

      
    }
  }
}