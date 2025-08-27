import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{-1,0},{0, 1}, {1,0}, {0,-1}};
  static List<int[]> meltCheese;
  static boolean[][] outsideAir;
  static int N, M;
  static int[][] cheese;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    cheese = new int[N][M];
    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        cheese[i][j] = Integer.parseInt(row[j]);
      }
    }

    int time = 0;
    while(true) {
      if (!hasCheese()) {
        System.out.println(time);
        break;
      }

      // 외부 공기 찾기
      findAir();
      // 외부 공기와 맞닿은 치즈 찾기(치즈있는자리 횟수증가)
      findMeltChees();
      // 해당 치즈 중에서 외부 공기가 2면이상 맞닿은 치즈 = 0으로 변경
      for (int[] melt : meltCheese) {
        cheese[melt[0]][melt[1]] = 0;
      }

      time++;


    }

  }
  static private boolean hasCheese(){
    for (int[] ch : cheese) {
      for (int c : ch) {
        if (c > 0) return true;
      }
    }
    return false;
  }

  static private void findMeltChees() {
    meltCheese = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (cheese[i][j] == 1) {
          int cnt = 0;
          for (int[] d :directions) {
            int nx = d[0] + i, ny = d[1] + j;
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
              if (outsideAir[nx][ny]) {
                cnt++;
              }
            }
          }

          if (cnt >= 2) meltCheese.add(new int[]{i, j});
        }
      }
    }
  }
  
  
  static private void findAir() {
    boolean[][] visited = new boolean[N][M];
    
    outsideAir = new boolean[N][M];
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0});
    visited[0][0] = true;
    while(!queue.isEmpty()) {
      int[] curr = queue.poll();

      int cx = curr[0], cy = curr[1];
      outsideAir[cx][cy] = true;

      for (int[] d : directions) {
        int nx = d[0] + cx, ny = d[1] + cy;
        if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
          if (cheese[nx][ny] == 0) {
            visited[nx][ny] = true;
            queue.add(new int[]{nx, ny});
          }
        }
      }
    }

  }

}