import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static int[][] cheese;
  static boolean[][] visited;
  static int meltTime, lastCheesePiece = 0;
  static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
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

    while(true) {
      visited = new boolean[N][M];

      meltingCheese(0, 0); 

      int count = 0;

    
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (cheese[i][j] == 1 && isMelted(i,j)) {
            cheese[i][j] = 0;
            count++;
          }
        }
      }

      if (count == 0) break;


      lastCheesePiece = count;
      meltTime++;
    }

    System.out.println(meltTime);
    System.out.println(lastCheesePiece);



    
    
  }

  static void meltingCheese(int x, int y) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x, y});
    visited[x][y] = true;

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();

      int cx = curr[0], cy = curr[1];

      for (int[] dir : directions) {
        int nx = dir[0] + cx, ny = dir[1] + cy;

        if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
          if (cheese[nx][ny] == 0) {
            visited[nx][ny] = true;
            queue.add(new int[]{nx, ny});
          }
        }
      }
    }
  }

  static boolean isMelted(int x, int y) {
    
    for (int[] dir : directions) {
      int nx = dir[0] + x, ny = dir[1] + y;

      if (0 <= nx && nx < N && 0 <= ny && ny < M) {
        if (visited[nx][ny]) {
          return true;
        }
      }
    }

    return false;
  }


} 