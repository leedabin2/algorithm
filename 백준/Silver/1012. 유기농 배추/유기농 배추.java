import java.util.*;
import java.io.*;
class Main {
    static int N, M;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
          String[] row = br.readLine().split(" ");
          N = Integer.parseInt(row[0]);
          M = Integer.parseInt(row[1]);

          int[][] graph = new int[N][M];

          int K = Integer.parseInt(row[2]);

          for (int i = 0; i < K; i++) {
            String[] info = br.readLine().split(" ");

            int x = Integer.parseInt(info[0]);
            int y = Integer.parseInt(info[1]);

            graph[x][y] = 1;

          }

          boolean[][] visited = new boolean[N][M];
          Deque<int[]> queue = new ArrayDeque<>();
          int cnt = 0;
          for (int i =0; i < N; i++) {
            for (int j = 0; j < M; j++) {
              if (!visited[i][j] && graph[i][j] == 1) {
                bfs(i, j, graph, visited, queue);
                cnt++;
              }
            }
          }

          System.out.println(cnt);

     
        }

    }
    static void bfs(int x, int y, int[][] graph, boolean[][] visited, Deque<int[]> queue ) {
      queue.add(new int[]{x, y});
      visited[x][y] = true;

      while (!queue.isEmpty()) {

        int[] curr = queue.poll();

        int cx = curr[0]; int cy = curr[1];

        for (int d = 0 ;d < 4; d++) {
          int nx = cx + dx[d]; int ny = cy + dy[d];

          if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
          if (!visited[nx][ny] && graph[nx][ny] == 1) {
            visited[nx][ny] = true;
            queue.add(new int[]{nx, ny});
          }
        }
        
      }
    }
}