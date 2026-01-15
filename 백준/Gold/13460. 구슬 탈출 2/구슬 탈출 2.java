import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
  static final int LIMIT = 10;
  static int N, M;
  static char[][] board;
  static int answer =0;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);

      int rx = 0; int ry = 0; int bx = 0; int by = 0;
      board = new char[N][M];
      for (int i = 0; i < N; i++) {
        String s = br.readLine();
        for (int j = 0; j < M; j++) {
          board[i][j] = s.charAt(j);
          if (board[i][j] == 'R') {
            rx = i; ry = j;
          } 
          if (board[i][j] == 'B') {
            bx = i; by = j;
          }
        }
      }

      boolean[][][][] visited = new boolean[N][M][N][M]; 
      visited[rx][ry][bx][by] = true;
      Deque<int[]> queue = new ArrayDeque<>();
      queue.add(new int[]{rx, ry, bx, by, 0});
      while (!queue.isEmpty()) {

        int[] cur = queue.poll();

        int rcx = cur[0]; int rcy = cur[1];
        int bcx = cur[2]; int bcy = cur[3];
        int depth = cur[4];

        if (depth == LIMIT) break;

        for (int d = 0; d < 4; d++) {
          // 계속 한 방향으로 이동
          int[] red = move(rcx, rcy, d);
          int[] blue = move(bcx, bcy, d);

          int rnx = red[0]; int rny = red[1]; int rMove = red[2];
          int bnx = blue[0]; int bny = blue[1]; int bMove = blue[2];

          // 파란색 공이 빠지면 실패
          if (board[bnx][bny] == 'O') continue;
          // 빨간색 공이 빠지면 성공
          if (board[rnx][rny] == 'O') {
            answer = depth+1;
            System.out.println(answer);
            return;
          }

          // 같은 위치면 더 많이 이동한 구슬을 한 칸 뒤로
          if (rnx == bnx && rny == bny) {
            if (rMove > bMove) {
              rnx -= dx[d];
              rny -= dy[d];
            } else {
              bnx -= dx[d];
              bny -= dy[d];
            }
          }

          if (!visited[rnx][rny][bnx][bny]) {
            visited[rnx][rny][bnx][bny] = true;
            queue.add(new int[]{rnx, rny, bnx, bny, depth + 1});
          }
        }
        
      }

      System.out.println(-1);

      
   }
  static int[] move(int x, int y, int d) {
    int count = 0;

    while (true) {
      int nx = x + dx[d];
      int ny = y + dy[d];
      if (board[nx][ny] == '#') break;
      x = nx;
      y = ny;
      count++;
      if (board[x][y] == 'O') break;
    }
    return new int[]{x, y, count};
  }
}