import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int R = Integer.parseInt(st[0]);
    int C = Integer.parseInt(st[1]);
    int T = Integer.parseInt(st[2]);

    int[][] room = new int[R][C];

    // 공기청정기 위치(두 줄) 저장
    int upX = -1, downX = -1;
    for (int i = 0; i < R; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < C; j++) {
        room[i][j] = Integer.parseInt(row[j]);
        if (room[i][j] == -1) {
          if (upX == -1) upX = i; else downX = i;
        }
      }
    }

    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    int second = 0; // 초
    int total = 0;

    while (true) {
      second++;

      // 1) 미세먼지 확산
      int[][] add = new int[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          int dust = room[i][j];
          if (dust <= 0) continue; 
          int spread = dust / 5;
          if (spread == 0) continue;

          int cnt = 0;
          for (int[] dir : directions) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if (room[nx][ny] == -1) continue; // 청정기 칸 제외
            add[nx][ny] += spread;
            cnt++;
          }
          room[i][j] -= spread * cnt;        // 남은 양
        }
      }
      // 확산 누적 적용
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (room[i][j] != -1) room[i][j] += add[i][j];
        }
      }

      // 2) 공기청정기 작동
      // 위쪽(반시계)
      for (int i = upX - 1; i > 0; i--) room[i][0] = room[i - 1][0];
      for (int j = 0; j < C - 1; j++)   room[0][j] = room[0][j + 1];
      for (int i = 0; i < upX; i++)     room[i][C - 1] = room[i + 1][C - 1];
      for (int j = C - 1; j > 1; j--)   room[upX][j] = room[upX][j - 1];
      room[upX][1] = 0;

      // 아래쪽(시계)
      for (int i = downX + 1; i < R - 1; i++) room[i][0] = room[i + 1][0];
      for (int j = 0; j < C - 1; j++)         room[R - 1][j] = room[R - 1][j + 1];
      for (int i = R - 1; i > downX; i--)     room[i][C - 1] = room[i - 1][C - 1];
      for (int j = C - 1; j > 1; j--)         room[downX][j] = room[downX][j - 1];
      room[downX][1] = 0;

      // 청정기 위치 유지
      room[upX][0] = -1;
      room[downX][0] = -1;

      // 3) 끝났으면 합계
      if (second == T) {
        for (int i = 0; i < R; i++) {
          for (int j = 0; j < C; j++) {
            if (room[i][j] > 0) total += room[i][j];
          }
        }
        break;
      }
    }

    System.out.println(total);
  }
}
