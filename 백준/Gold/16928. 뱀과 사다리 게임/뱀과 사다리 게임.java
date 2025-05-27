import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static int[] move = new int[101];
  static int[] visited = new int[101];
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    for (int i =1; i <= 100; i++) move[i] = i;

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      int x = Integer.parseInt(row[0]);
      int y = Integer.parseInt(row[1]);
      move[x] = y;
    }

    for (int i = 0; i < M; i++) {
      String[] row = br.readLine().split(" ");
      int x = Integer.parseInt(row[0]);
      int y = Integer.parseInt(row[1]);
      move[x] = y;
    }

    bfs();

  }

  static void bfs() {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    visited[1] = 0;

    while(!queue.isEmpty()) {
      int curr = queue.poll();

      if (curr == 100) {
        System.out.println(visited[curr]);
        return;
      }

      for (int i = 1; i <= 6; i++) {
        int next = curr + i;
        if (next > 100) continue;

        int start = move[next];
        if (visited[start] == 0 && start != 1) {
          visited[start] = visited[curr] + 1;
          queue.add(start);
        }
      }


    }
  }
} 