import java.io.*;
import java.util.*;

class Main {
  static int R, C, M;
  static int[][] board;
  static List<int[]> sharks;
  static int[] speed;
  static int[] direction;
  static int[] size;
  static int[] dx = new int[]{0,-1,1,0,0}; // 상 하 우 좌
  static int[] dy = new int[]{0,0,0,1,-1};
  static int answer = 0;
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    R = Integer.parseInt(st[0]);
    C = Integer.parseInt(st[1]);
    M = Integer.parseInt(st[2]);

    board = new int[R][C];
    speed = new int[M+1];
    direction = new int[M+1];
    size = new int[M+1];
    sharks = new ArrayList<>();

    for (int i = 1; i <= M; i++) {
      String[] info = br.readLine().split(" ");
      int r = Integer.parseInt(info[0])-1;
      int c = Integer.parseInt(info[1])-1;
      int s = Integer.parseInt(info[2]);
      int d = Integer.parseInt(info[3]);
      int z = Integer.parseInt(info[4]);

      sharks.add(new int[]{i, r, c});
      board[r][c] = i;
      speed[i] = s;
      direction[i] = d;
      size[i] = z;
    }

    int move = -1;
    while (true) {

      if (move == C-1) {
        System.out.println(answer);
        return;
      }

      move++;
      // 오른쪽이동 후 상어잡음
      for (int r = 0; r < R; r++) {
        if (board[r][move] > 0) {
          // 상어가 있다면 잡음
          int shark = board[r][move];
          answer += size[shark];
          size[shark] = 0;
          direction[shark] = 0;
          speed[shark] = 0;
          break;
        }
      }

      // 상어이동
      moveShark();
    }


   }
   static void moveShark() {
    List<int[]> newSharks = new ArrayList<>();
    int[][] newBoard = new int[R][C];
    for (int[] s : sharks) {
      int id = s[0];
      int r = s[1];
      int c = s[2];

      if (size[id] == 0) continue;

      int dir = direction[id];
      int spd = speed[id];

      int cycle;

      if (dir == 1 || dir == 2)
          cycle = 2 * (R - 1);
      else
          cycle = 2 * (C - 1);

      spd %= cycle;

      // 해당 방향으로 이동
      int nr = r;
      int nc = c;
      for (int j = 0; j < spd; j++) {
        nr += dx[dir];
        nc += dy[dir];
        if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
          // 원래대로 되돌림
          nr -= dx[dir];
          nc -= dy[dir];

          // 방향 반전
          if (dir == 1) dir = 2;
          else if (dir == 2) dir = 1;
          else if (dir == 3) dir = 4;
          else dir = 3;

          nr += dx[dir];
          nc += dy[dir];
        }
      }

      direction[id] = dir;

      // 충돌처리
      if (newBoard[nr][nc] == 0) {
        newBoard[nr][nc] = id;
        newSharks.add(new int[]{id, nr, nc});
      } else {
        int other = newBoard[nr][nc];
        if (size[other] < size[id]) {
          size[other] = 0;
          newBoard[nr][nc] = id;
          newSharks.add(new int[]{id, nr, nc});
        } else {
          size[id] = 0;
        }
      }

      sharks = newSharks;
      board = newBoard;
    }
   }
}