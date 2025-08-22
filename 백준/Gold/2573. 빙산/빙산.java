import java.util.*;
import java.io.*;

class Main {
  static boolean[][] visited;
  static int[][] ice;
  static int N, M;
  static int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    // 1 : 30
    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    ice = new int[N][M];
    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        ice[i][j] = Integer.parseInt(row[j]);
      }
    }

    int time = 0;

    while(true) {

      // 빙산이 전부 녹았으면 종료
      if (allMelted()) {
        System.out.println(0);
        return;
      }

      time++;
      // 상하좌우로 0이 몇개인지 체크 후 저장
      List<int[]> melt = new ArrayList<>();
      visited = new boolean[N][M];
      for (int i =0;i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (ice[i][j] > 0) {
            int cnt = 0;
            for (int[] d : directions) {
              int nx = d[0] + i;
              int ny = d[1] + j;
              if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (ice[nx][ny] == 0) {
                  cnt++;
                }
              }
            }
            melt.add(new int[]{i,j,cnt}); // 빙산의 위치, 양 옆 0개수
          }
        }
      }
      // 그만 큼 빼기 

      for (int[] m : melt) {
        int x = m[0], y = m[1], minus = m[2];

        ice[x][y] -= minus;
        if (ice[x][y] < 0) ice[x][y] = 0;
      }


      // 상하좌우로 몇개인제 셈
      visited = new boolean[N][M];
      int groups = 0;
      for (int i =0; i < N; i++) {
        for (int j =0; j < M; j++) {
          if (ice[i][j] > 0 && !visited[i][j]) {
            count(i, j);
            groups++;
          }
        }
      }

      // 두 덩어리 이상이면 time 출력
      if (groups >= 2) {
        System.out.println(time);
        return;
      } 
    
    }
   
  }
  static private boolean allMelted() {
    boolean allMelt = false;
    for (int i = 0; i < N; i++) {
      for (int j =0; j < M; j++) {
        if (ice[i][j] > 0) return false;
      }
    }

    return true;
  }
  static private void count(int x, int y) {
    visited[x][y] = true;
    for (int[] d : directions) {
          int nx = d[0] + x;
          int ny = d[1] + y;
          if (0 <= nx && nx < N && ny >= 0 && ny < M) {
            if (ice[nx][ny] > 0 && !visited[nx][ny]) {
              visited[nx][ny] = true;
              count(nx, ny);
            }
          }
        }
  }
} 