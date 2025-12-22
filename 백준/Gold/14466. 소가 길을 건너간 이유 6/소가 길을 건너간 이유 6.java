import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class Main {
  static int N, K, R;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  static boolean[][][] blocked;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[0]);
      K = Integer.parseInt(st[1]);
      R = Integer.parseInt(st[2]);

      blocked = new boolean[N][N][4];

      for (int i = 0; i < R; i++) {
        String[] line = br.readLine().split(" ");

        int r1 = Integer.parseInt(line[0]) - 1;
        int c1 = Integer.parseInt(line[1]) - 1;
        int r2 = Integer.parseInt(line[2]) - 1;
        int c2 = Integer.parseInt(line[3]) - 1;

        for (int dir = 0; dir < 4; dir++) {
          int nr = r1 + dx[dir];
          int nc = c1 + dy[dir];

          if (nr == r2  && nc == c2) {
            blocked[nr][nc][dir] = true;
          }
        }

        for (int dir = 0; dir < 4; dir++) {
          int nr = r2 + dx[dir];
          int nc = c2 + dy[dir];

          if (nr == r1 && nc == c1) {
            blocked[nr][nc][dir] = true;
          }
        }
      }

      List<int[]> cows = new ArrayList<>();
      for (int i = 0; i < K; i++) {
        String[] cowInfo = br.readLine().split(" ");
        int r = Integer.parseInt(cowInfo[0])-1;
        int c = Integer.parseInt(cowInfo[1])-1;

        cows.add(new int[]{r, c});
      }

      int answer = 0;

      for (int i =0; i < K; i++) {
        boolean[][] reachable = bfs(cows.get(i)[0], cows.get(i)[1]);

        // 다른 소들이 도달 불가능하다면 
        for (int j = i + 1; j < K; j++) {
          int[] cow2 = cows.get(j);
          if (!reachable[cow2[0]][cow2[1]]) {
            answer++;
          }
        }
      }

      System.out.println(answer);
  }
  static boolean[][] bfs(int r, int c) {
    boolean[][] visited = new boolean[N][N];

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{r, c});
    visited[r][c] = true;

    while (!queue.isEmpty()) {

      int[] cur = queue.poll();
      int x = cur[0], y = cur[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
        if (visited[nx][ny]) continue;

        // 길이 막혀있다면 이동 불가
        if (blocked[nx][ny][d]) continue;

        visited[nx][ny] = true;
        queue.add(new int[]{nx, ny});
      }
      
    }

    return visited;
  }
}