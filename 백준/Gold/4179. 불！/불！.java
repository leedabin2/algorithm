import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{-1,0},{0, 1}, {1,0}, {0,-1}};
  static int[][] fireTime;
  static int[][] jihunTime;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    // 1 : 46
    String[] st = br.readLine().split(" ");

    int R = Integer.parseInt(st[0]);
    int C = Integer.parseInt(st[1]);

    char[][] board = new char[R][C];
    fireTime = new int[R][C];
    jihunTime = new int[R][C];

    Deque<int[]> fireQ = new ArrayDeque<>();
    Deque<int[]> jihunQ = new ArrayDeque<>();
    for (int i = 0; i < R; i++) {
      String row = br.readLine();
      for (int j = 0; j < C; j++) {
        board[i][j] = row.charAt(j);
        fireTime[i][j] = -1;
        jihunTime[i][j] = -1;
        if (board[i][j] == 'F') {
          fireQ.add(new int[]{i,j});
          fireTime[i][j] = 0;
        }
        if (board[i][j] == 'J') {
          jihunQ.add(new int[]{i,j});
          jihunTime[i][j] = 0;
        }
      }
    }

    int time = 0;

    while(!fireQ.isEmpty()) {
      int[] curr =fireQ.poll();

      int cx = curr[0], cy = curr[1];

      for (int[] d : directions) {
        int nx = d[0] + cx, ny = d[1] + cy;

        if (nx >= 0 && nx < R && 0 <= ny && ny < C) {
          if (fireTime[nx][ny] == -1 && board[nx][ny] != '#') {
            fireTime[nx][ny] = fireTime[cx][cy] + 1;
            fireQ.add(new int[]{nx, ny});
          }
        }
      }
    }

    while(!jihunQ.isEmpty()) {
      int[] curr =jihunQ.poll();
      int cx = curr[0], cy = curr[1];

      for (int[] d : directions) {
        int nx = d[0] + cx, ny = d[1] + cy;
        if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
          System.out.println(jihunTime[cx][cy] + 1);
          return;
        }
        if (jihunTime[nx][ny] != -1 || board[nx][ny] == '#') continue;
        if (1 + jihunTime[cx][cy] < fireTime[nx][ny] || fireTime[nx][ny] == -1) {
          jihunTime[nx][ny] = 1 + jihunTime[cx][cy];
          jihunQ.add(new int[]{nx, ny});
        }
      }
    }

    
  


    
    

    System.out.println("IMPOSSIBLE");


  }
} 