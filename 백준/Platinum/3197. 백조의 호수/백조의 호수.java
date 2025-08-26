import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{-1,0},{0, 1}, {1,0}, {0,-1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int R = Integer.parseInt(st[0]);
    int C = Integer.parseInt(st[1]);

    char[][] board = new char[R][C];
    boolean[][] visited = new boolean[R][C];
    for (int i = 0; i < R; i++) {
      String row = br.readLine();
      for (int j = 0; j < C; j++) {
        board[i][j] = row.charAt(j);
      }
    }

    List<int[]> swans = new ArrayList<>();
     for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (board[i][j] == 'L') swans.add(new int[]{i,j});
      }
    }

    Deque<int[]> swanQueue = new ArrayDeque<>();
    Deque<int[]> nextSwanQueue = new ArrayDeque<>();

    boolean[][] swanVisited = new boolean[R][C];
    int[] swan1 = swans.get(0);
    int[] swan2 = swans.get(1);
    swanQueue.add(new int[]{swan1[0], swan1[1]});
    swanVisited[swan1[0]][swan1[1]] = true;

    Deque<int[]> waterQueue = new ArrayDeque<>();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (board[i][j] == '.' || board[i][j] == 'L') {
          for (int[] d :directions) {
            int nx = i + d[0], ny = j + d[1];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] == 'X') {
                waterQueue.add(new int[]{i, j});
                break;
            }
          }
        }
      }
    }
    int day = 0;
    while(true) {

      // 백조 이동 (대각선에 백조 있으면 day출력)
      boolean canMeet = false;
      while(!swanQueue.isEmpty()) {
        int[] curr = swanQueue.poll();

        int x = curr[0], y = curr[1];
        if (x == swan2[0] && y == swan2[1]) {
          canMeet = true;
          break;
        }

        for (int[] d : directions) {
          int nx = d[0] + x, ny = d[1] + y;

          if (nx >= 0 && nx < R && ny >= 0 && ny < C && !swanVisited[nx][ny]) {
            swanVisited[nx][ny] = true;

           if (board[nx][ny] == '.' || board[nx][ny] == 'L') {
                swanQueue.add(new int[]{nx, ny});  
            } else if (board[nx][ny] == 'X') {
                nextSwanQueue.add(new int[]{nx, ny});  // 다음날 탐색
            }
          }
        }
      }

      if (canMeet) {
        System.out.println(day);
        return;
      }
     
      // 빙판 녹이기
      int waterSize = waterQueue.size();
      for (int i = 0; i < waterSize; i++) {
        int[] curr = waterQueue.poll();
        int x = curr[0], y = curr[1];
        
        for (int[] d : directions) {
          int nx = x + d[0], ny = y + d[1];
          
          if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] == 'X') {
              board[nx][ny] = '.';  
              waterQueue.add(new int[]{nx, ny});  // 새로운 물 경계
          }
        }
      }

      // 다음 탐색
      swanQueue = nextSwanQueue;
      nextSwanQueue = new ArrayDeque<>();


      day++;
    }
  }
}