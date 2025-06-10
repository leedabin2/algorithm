import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);

    int[][] board = new int[N][N];
    int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }

    String[] input = br.readLine().split(" ");
    int S = Integer.parseInt(input[0]);
    int X = Integer.parseInt(input[1]) - 1;
    int Y = Integer.parseInt(input[2]) - 1;

    List<int[]> viruses = new ArrayList<>();
    Deque<int[]> queue = new ArrayDeque<>();
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] != 0) viruses.add(new int[]{board[i][j],0,i,j});
      }
    }

    viruses.sort(Comparator.comparingInt(a -> a[0]));
    for (int[] virus : viruses) queue.add(virus);

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();

      int virus = curr[0],time = curr[1], cx = curr[2], cy = curr[3];

      if (time == S) break;

      for (int[] dir: directions) {
        int nx = dir[0] + cx, ny = dir[1] + cy;
        if ( 0 <= nx && nx < N && 0 <= ny && ny < N) {
          if (board[nx][ny] == 0) {
            board[nx][ny] = virus;
            queue.add(new int[]{virus, time+1, nx, ny});
          }
        }
      }

    }

    System.out.println(board[X][Y] == 0 ? 0 : board[X][Y]);
  }
} 