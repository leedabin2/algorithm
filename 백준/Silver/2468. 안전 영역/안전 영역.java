import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        int maxH = -1;
        for (int i =0; i < n; i++) {
          String[] st = br.readLine().split(" ");
          for (int j = 0; j < n; j++) {
            graph[i][j] = Integer.parseInt(st[j]);
            maxH = Math.max(maxH, graph[i][j]);
          }
        }

        int answer = 0;
        for (int h =0; h <= maxH; h++) {
          visited = new boolean[n][n];
          int count = 0;
          for (int i =0; i < n; i++) {
            for (int j =0; j < n; j++) {
              if (!visited[i][j] && graph[i][j] > h) {
                bfs(i, j, h);
                count++;
              }
            }
          }

          answer = Math.max(answer, count);

        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y, int height) {
      Deque<int[]> q = new ArrayDeque<>();
      q.add(new int[]{x, y});
      visited[x][y] = true;

      while(!q.isEmpty()) {
        int[] curr = q.poll();

        int cx = curr[0], cy = curr[1];
        for (int[] d : directions) {
          int nx = d[0] + cx;
          int ny = d[1] + cy;

          if (nx < 0 || ny < 0 || nx >= n | ny >= n) continue;
          if (visited[nx][ny]) continue;
          if (graph[nx][ny] <= height) continue;

          visited[nx][ny] = true;
          q.add(new int[]{nx, ny});
        }

      }
    }
}

