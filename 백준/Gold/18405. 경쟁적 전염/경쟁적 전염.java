import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{-1,0},{0, 1}, {1,0}, {0,-1}};
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    // 1 
    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);

    int[][] board = new int[N][N];
    List<int[]> virusList = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(row[j]);
        if (board[i][j] > 0) virusList.add(new int[]{board[i][j], i, j});
      }
    }

    String[] input = br.readLine().split(" ");
    int S = Integer.parseInt(input[0]);
    int X = Integer.parseInt(input[1]) - 1;
    int Y = Integer.parseInt(input[2]) - 1;


    Collections.sort(virusList, (a, b) -> Integer.compare(a[0], b[0]));


    Deque<int[]> queue = new ArrayDeque<>();

    for (int[] v : virusList) {
      queue.add(v);
    }
    
    int time = 0;
    while(!queue.isEmpty() && time < S) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] curr = queue.poll();

        int virus = curr[0], x = curr[1], y = curr[2];
        for (int[] d: directions) {
          int nx =d[0] + x, ny = d[1] + y;

          if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            if (board[nx][ny] == 0) {
              board[nx][ny] = virus;
              queue.add(new int[]{virus, nx, ny});
            }
          }
        }
      }

      time++;

      
    }

    System.out.println(board[X][Y] > 0 ? board[X][Y] : 0);

  }
}