import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {
  static int N = 12;
  static int M = 6;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static char[][] map;
  static int answer;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      map = new char[N][M];

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split("");
        for (int j = 0; j < M; j++) {
          map[i][j] = row[j].charAt(0);
        }
      }

      answer = 0;

      while (true) {

        boolean[][] visited = new boolean[N][M];
        boolean popped = false;

        // 터질 그룹 찾기
        for (int i =0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            if (map[i][j] == '.' || visited[i][j]) continue;

            List<int[]> group = bfs(i, j, visited);

            if (group.size() >= 4) {
              popped =true;
              for (int[] cell : group) {
                map[cell[0]][cell[1]] = '.';
              }
            }
          }
        }

        if (!popped) break;

        dropAll();

        answer++;
        
      }

      System.out.println(answer);

   }

   static void dropAll() {
    for (int j =0; j < M; j++) {
      int write = N-1; // 아래부터 채우기 
      for (int i = N-1; i >= 0; i--) {
        if (map[i][j] != '.') {
          map[write][j] = map[i][j];
          if (write != i) map[i][j] = '.';
          write--;
        }
      }

      for (int i = write; i >= 0; i--) {
        map[i][j] = '.';
      }
    }
   }
   static List<int[]> bfs(int x, int y, boolean[][] visited) {
    List<int[]> group = new ArrayList<>();
    Deque<int[]> queue = new  ArrayDeque<>();

    visited[x][y] = true;
    queue.add(new int[]{x, y});

    char color = map[x][y];

    while (!queue.isEmpty()) {

      int[] cur = queue.poll();
      int cx = cur[0], cy = cur[1];

      group.add(cur);

      for (int d = 0; d<4; d++) {
        int nx = dx[d] + cx, ny = dy[d] + cy;
        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
        if (visited[nx][ny]) continue;

        if (map[nx][ny] == color) {
          visited[nx][ny] = true;
          queue.add(new int[]{nx, ny});
        }
      }
      
    }
    return group;
    
   }
}