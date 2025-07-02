import java.util.*;
import java.io.*;

class Main {
  static int R, C;
  static char[][] board;
  static int[][] waterTime;
  static boolean[][] visited;
  static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    R = Integer.parseInt(st[0]);
    C = Integer.parseInt(st[1]);

    board = new char[R][C];
    visited = new boolean[R][C];
    waterTime = new int[R][C];

    for (int i =0 ;i < R; i++) {
      String row = br.readLine();
      for (int j =0 ; j < C; j++) {
        board[i][j] = row.charAt(j);
      }
    }

    for (int i =0; i < R; i++) {
      Arrays.fill(waterTime[i], -1);
    }

    Deque<int[]> water = new ArrayDeque<>();
    Deque<int[]> hedgehog = new ArrayDeque<>();

    for (int i =0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (board[i][j] == '*') {
          water.add(new int[]{i,j, 0});
          waterTime[i][j] = 0;
        }
        else if (board[i][j] == 'S') {
          hedgehog.add(new int[]{i,j,0});
          visited[i][j] = true;
        }
      }
    }

    // 물 확산 시간 계산
    while(!water.isEmpty()) {
      int[] curr = water.poll();

      int x = curr[0], y = curr[1], time = curr[2];

      for (int[] dir : directions) {
        int nx = dir[0] + x, ny = dir[1] + y;

        if (0 <= nx && nx < R && 0 <= ny && ny < C) {
          if (board[nx][ny] == '.' && waterTime[nx][ny] == -1) {
            waterTime[nx][ny] = time + 1;
            water.add(new int[]{nx, ny, time + 1});
          }
        }
      }
    }


    while(!hedgehog.isEmpty()) {
   

      int[] hedgehogCurr = hedgehog.poll();
      int x = hedgehogCurr[0], y = hedgehogCurr[1], time = hedgehogCurr[2];

      for (int[] dir : directions) {
        int nx = dir[0] + x, ny = dir[1] + y;

        if (0 <= nx && nx < R && 0 <= ny && ny < C  && !visited[nx][ny]) {
          if (board[nx][ny] == 'D') {
            System.out.println(time+1);
            return;
          }
          if (board[nx][ny] == '.' && (waterTime[nx][ny] == -1 || waterTime[nx][ny] > time + 1)) {
            visited[nx][ny] = true;
            hedgehog.add(new int[]{nx, ny, time+1});
          }
        }
        

      }
    
    }

    System.out.print("KAKTUS");



  }


} 