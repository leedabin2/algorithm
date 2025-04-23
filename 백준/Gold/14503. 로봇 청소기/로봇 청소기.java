// 청소불가능 : 후진가능하면 한 칸 후진 후 스캔
  // 후진 불가능 : 작동멈춤
// 청소가능: 반시계 방향으로 회전 - if 앞이 0 이면 한 칸 전진 후 청소

import java.util.*;
import java.io.*;

class Main {
    static int N, M, r, c, d;
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);
      String[] cmd = br.readLine().split(" ");
      r = Integer.parseInt(cmd[0]); 
      c = Integer.parseInt(cmd[1]);
      d = Integer.parseInt(cmd[2]);
      count = 0;
      graph = new int[N][M];
      visited = new boolean[N][M];
      for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
      }

      dfs(r,c,d);
      System.out.println(count);
    }

    private static void dfs(int x, int y,int d) {
      int[] dx = { -1, 0, 1, 0};
      int[] dy = {0, 1, 0, -1};
      // 1. 현재 위치 청소
      if (!visited[x][y]) {
        visited[x][y] = true;
        count++;
      }

      // 2. 주변 탐색
      for (int i = 0; i < 4; i++) {
        d = (d + 3) % 4;
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (0<= nx && nx < N && 0 <= ny && ny < M && graph[nx][ny] == 0) {
          if (!visited[nx][ny]) {
            dfs(nx,ny,d);
            return;
          }
        }
      }

      // 3. 후진
      int back = (d + 2) % 4;
      int bx = x + dx[back];
      int by = y + dy[back];

      if (0<= bx && bx < N && 0 <= by && by < M && graph[bx][by] == 0) {
          dfs(bx,by,d);
      }

      // 4. 후진 불가 -> 작동 멈춤 (return)
    }
}