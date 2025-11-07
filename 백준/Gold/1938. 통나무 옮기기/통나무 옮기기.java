import java.util.*;
import java.io.*;

class Main {
  static char[][] board;
  static int n;
  static boolean[][][] visited;
  static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      n = Integer.parseInt(br.readLine());
      board = new char[n][n];

      List<int[]> bq = new ArrayList<>();
      List<int[]> eq = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        String st = br.readLine();
        for (int j = 0; j < n; j++) {
          board[i][j] = st.charAt(j);
          if (board[i][j] == 'B') {
            bq.add(new int[]{i, j});
          }else if(board[i][j] == 'E') {
            eq.add(new int[]{i, j});
          }
        }
      }

      int[] bxy = bq.get(1);
      int dir = bxy[0] == bq.get(0)[0] ?  0 : 1;

      int[] exy = eq.get(1);
      int ex = exy[0], ey = exy[1];
      int edir = ex == eq.get(0)[0] ? 0 : 1;

      // 가로 : 0 , 세로 : 1

      Deque<int[]> q = new ArrayDeque<>();
      q.add(new int[]{bxy[0], bxy[1], 0, dir});

      visited = new boolean[n][n][2];
      visited[bxy[0]][bxy[1]][dir] = true;

      while(!q.isEmpty()) {

        int[] curr = q.poll();

        int cx = curr[0], cy = curr[1], cnt = curr[2], cdir = curr[3];

        if (cx == ex && cy == ey && cdir == edir) {
          System.out.println(cnt);
          return;
        }

        for (int[] d : directions) {
          int nx = cx + d[0], ny = cy + d[1];

          if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
          if (board[nx][ny] == 1) continue;
          if (visited[nx][ny][cdir]) continue;

          if (canMove(nx, ny, cdir)) {
            visited[nx][ny][cdir] = true;
            q.add(new int[]{nx, ny, cnt+1, cdir});
          
          }

          if (canRotate(cx, cy)) {
            int nd = (cdir == 0) ? 1 : 0;
            if (!visited[cx][cy][nd]) {
              visited[cx][cy][nd] = true;
              q.add(new int[]{cx, cy, cnt+1, nd});
            }
          }
          
        }

      }
      System.out.println(0);
    }
    private static boolean canMove(int x, int y, int dir) {
      for (int i = -1; i <= 1; i++) {
        int nx = x + (dir == 1 ? i : 0);
        int ny = y + (dir == 0 ? i : 0);
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) return false;
        if (board[nx][ny] == '1') return false;
      }

      return true;
    }

    private static boolean canRotate(int x, int y) {
      for (int i = x-1; i <= x+1; i++) {
        for (int j = y-1; j <= y+1; j++) {
          if (i < 0 || j < 0 || i >= n || j >= n) return false;
          if (board[i][j] == '1') return false;
        }
      }
      return true;
    }

     

}
