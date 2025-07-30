import java.util.*;
import java.io.*;

class Main {
  static List<int[]> virus = new ArrayList<>();
  static int[][] board;
  static int N, M;
  static int[][] temp;
  static int maxSafe = 0;
  static int[] dx = {-1,0,0,1};
  static int[] dy = {0,1, -1, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    // 바이러스 상하좌우에 벽을 일일이 설치해보고 안전하면 ㅇ
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    board = new int[N][M];

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");

      for (int j =0; j < M; j++) {
        board[i][j] = Integer.parseInt(row[j]);
        if (board[i][j] == 2) virus.add(new int[]{i, j});
      }
    }

    dfs(0);
    System.out.println(maxSafe);

  }

  static void dfs(int wall) {
    if (wall == 3) {
      spreadVirus();
      return;
    }

    for (int i =0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 0) {
          board[i][j] = 1;
          dfs(wall + 1);
          board[i][j] = 0;
        }
      }
    }

  }
  static void spreadVirus() {
    temp = new int[N][M];

    for (int i =0 ; i< N; i++) {
      temp[i] = board[i].clone();
    }

    Deque<int[]> q = new ArrayDeque<>();

    for (int[] v : virus) {
      q.add(v);
    }

    while(!q.isEmpty()) {
      int[] curr =q.poll();

      int cx = curr[0], cy = curr[1];

      for (int dir = 0; dir < 4; dir++) {
        int nx = dx[dir] + cx;
        int ny = dy[dir] + cy;

        if (0 <= nx && nx < N && 0 <= ny && ny < M ) {
          if (temp[nx][ny] ==0){
            temp[nx][ny] = 2;
            q.add(new int[]{nx, ny});
          }
        }
      }
    }

    countSafeZone();
  }

  static void countSafeZone(){
    int count = 0;
    for (int i =0; i < N; i++) {
      for (int j =0; j < M; j++) {
        if (temp[i][j] == 0 ) count++;
      }
    }

    maxSafe = Math.max(maxSafe, count);
  }
} 