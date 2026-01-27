import java.io.*;
import java.util.*;


class Main {
  static int R, C, N;
  static char[][] board;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static boolean[][] ground;
  static int[] height;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // 미네랄은 한 번만 제거
      // 공중에 떠있는 미네랄 -> 아래로

      String[] st = br.readLine().split(" ");
      R = Integer.parseInt(st[0]);
      C = Integer.parseInt(st[1]);

      board = new char[R][C];
      for (int i = 0; i < R; i++) {
        String row = br.readLine();
        for (int j = 0; j < C; j++) {
          board[i][j] = row.charAt(j);
        }
      }


      N = Integer.parseInt(br.readLine());
      String[] h = br.readLine().split(" ");
     
      for (int turn = 0; turn < N; turn++) {
        int height = R - Integer.parseInt(h[turn]);
        // 막대 던지기
        if (turn % 2 == 0) {
          // 왼 -> 오
          for (int j = 0; j < C; j++) {
            if (board[height][j] == 'x') {
              board[height][j] = '.';
              break;
            }
          }
        } else {
          // 오 -> 왼
          for (int j = C-1; j >= 0; j--) {
            if (board[height][j] == 'x') {
              board[height][j] = '.';
              break;
            }
          }
        }

        // 바닥인지 체크
        ground = new boolean[R][C];
        for (int j = 0; j < C; j++) {
          if (board[R-1][j] == 'x' && !ground[R-1][j]) {
            bfs(R-1, j, ground);
          }
        }

        // 공중클러스터 수집
        List<int[]> floating = new ArrayList<>();
        for (int i = 0; i <R; i++) {
          for (int j = 0; j < C; j++) {
            if (board[i][j] == 'x' && !ground[i][j]) {
              floating.add(new int[]{i, j});
            }
          }
        }

        if (floating.isEmpty()) continue;

        // 클러스트 제거
        for (int[] f : floating) {
            board[f[0]][f[1]] = '.';
        }

        // 낙하거리 계산
        int fall = Integer.MAX_VALUE;
        for (int[] f : floating) {
          int x = f[0]; int y = f[1];
          int dist = 0;
          int nx = x + 1;

          while (nx < R && board[nx][y] == '.') {
              nx++;
              dist++;
          }
          fall = Math.min(fall, dist);
        }

        // 클러스트 추락
        for (int[] f : floating) {
          board[f[0] + fall][f[1]] = 'x';
        }

      }

       // 출력
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < R; i++) {
          sb.append(board[i]).append('\n');
      }
      System.out.print(sb.toString());


   }
   static void bfs(int x , int y, boolean[][] ground) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x, y});
    ground[x][y] = true;

    while (!queue.isEmpty()) {

      int[] cur = queue.poll();
      int cx =cur[0]; int cy = cur[1];
      for (int d= 0; d < 4; d++) {
        int nx = dx[d] + cx; int ny = dy[d] + cy;
        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
        if (ground[nx][ny] || board[nx][ny] != 'x') continue;

        ground[nx][ny] = true;
        queue.add(new int[]{nx, ny});
    }
      
    }
   }
}
