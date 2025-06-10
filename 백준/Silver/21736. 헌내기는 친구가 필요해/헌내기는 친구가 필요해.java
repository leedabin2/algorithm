import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
  static String[] board;
  static boolean[][] visited;
  static int meet, N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");

    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    board = new String[N];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      board[i] = row;
    }

    int answer = 0;

    for (int i =0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if(board[i].charAt(j) == 'I') {
          answer = bfs(i,j);
        }
      }
    }

    if (answer == 0) System.out.println("TT");
    else System.out.println(meet);
  }
  static int bfs(int x, int y) {
    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{x,y});
    visited[x][y] = true;

    while(!queue.isEmpty()){
      int[] curr = queue.poll();
      int cx = curr[0], cy = curr[1];
     
      if (board[cx].charAt(cy) == 'P') {
        meet++;
        }

      for (int[] dir : directions) {
        int nx = dir[0] + cx;
        int ny = dir[1] + cy;

        if (0<=nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
          if (board[nx].charAt(ny) != 'X') {
            visited[nx][ny] = true;
            queue.add(new int[]{nx,ny});
            
          }
        }
      }
    }

    return meet;
  }
} 