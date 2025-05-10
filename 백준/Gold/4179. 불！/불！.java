import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static Character[][] board;
  static int[][] directions;
  static int[][] fireTime, jihoonTime;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    board = new Character[N][M];
    fireTime = new int[N][M];
    jihoonTime = new int[N][M];

    directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    for (int i = 0; i < N; i++) {
      String l = br.readLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = l.charAt(j);
        fireTime[i][j] = -1;
        jihoonTime[i][j] = -1;
      }
    }

    Deque<int[]> fireQueue = new ArrayDeque<>();
    Deque<int[]> jihoonQueue = new ArrayDeque<>();

  
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 'F') {
          fireQueue.add(new int[]{i,j});
          fireTime[i][j] = 0;
        }
        if (board[i][j] == 'J') {
          jihoonQueue.add(new int[]{i,j});
          jihoonTime[i][j] = 0;
        }
      }
    }

    while(!fireQueue.isEmpty()) {
      int[] curr = fireQueue.poll();
      for (int[] dir : directions) {
        int nx = dir[0] + curr[0], ny = dir[1] + curr[1];

        if (0<=nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == '.' && fireTime[nx][ny] == -1) {
          fireTime[nx][ny] = fireTime[curr[0]][curr[1]] + 1;
          fireQueue.add(new int[]{nx,ny});
          
        }
      }
    }

    while(!jihoonQueue.isEmpty()) {
      int[] curr = jihoonQueue.poll();

      if (curr[0] == 0 || curr[0] == N-1 || curr[1] == 0 || curr[1] == M-1) {
        System.out.print(jihoonTime[curr[0]][curr[1]] + 1);
        return;
      }
      for (int[] dir : directions) {
        int nx = dir[0] + curr[0], ny = dir[1] + curr[1];
        if (0<=nx && nx < N && 0 <= ny && ny < M && board[nx][ny] == '.') {
          if (jihoonTime[nx][ny] == -1 && (fireTime[nx][ny] == -1 || fireTime[nx][ny] > jihoonTime[curr[0]][curr[1]] + 1)) {
            jihoonTime[nx][ny] = jihoonTime[curr[0]][curr[1]] + 1;
            jihoonQueue.add(new int[]{nx,ny});
          }
         }
         
      }
    }

    System.out.println("IMPOSSIBLE");

 



  }

}