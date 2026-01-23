import java.io.*;

class Main {
  static int R, C;
  static char[][] board;
  static boolean[][] visited;
  static int[] dx = {-1, 0, 1}; // 방향 우선순위
  static int[] dy = {1, 1, 1};
  
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      R = Integer.parseInt(st[0]);
      C = Integer.parseInt(st[1]);

      board = new char[R][C];
      for (int i = 0; i < R; i++) {
        board[i] = br.readLine().toCharArray();
      }

      visited = new boolean[R][C];

      int pipeLine = 0;
      for (int i = 0; i < R; i++) {
        if (board[i][0] == 'x') continue;
        visited[i][0] = true;
        if (dfs(i, 0)) pipeLine++;
      }

      System.out.println(pipeLine);
   }

   static boolean dfs(int x, int y) {
      if (board[x][y] == 'x') return false;
      if (y == C - 1) return true;

      for (int d = 0; d < 3; d++) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
        if (visited[nx][ny] || board[nx][ny] == 'x') continue;

        visited[nx][ny] = true;
        if (dfs(nx, ny)) return true;
      }
      return false;
   }
}
