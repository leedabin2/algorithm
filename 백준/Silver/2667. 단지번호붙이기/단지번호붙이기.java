import java.util.*;
import java.io.*;

class Main {
    static int N, dangi;
    static int[][] board;
    static boolean[][] visited;
    static int[][] directions;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String st = br.readLine();

      N = Integer.parseInt(st);

      board = new int[N][N];

      for (int i = 0; i < N; i++) {
        String[] line = br.readLine().split("");
        for (int j = 0 ; j < N ; j++) {
          board[i][j] = Integer.parseInt(line[j]);
        }
      }
    visited = new boolean[N][N];
    directions = new int[][]{{-1,0},{0,1},{1,0}, {0,-1}};
    List<Integer> dangiSizes = new ArrayList<>();

    for (int i =0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] != 0 && !visited[i][j]) {
          dangi = 1;
          dfs(i,j);
          dangiSizes.add(dangi);
        }
      }
    }
    Collections.sort(dangiSizes);
    System.out.println(dangiSizes.size());
    for (int size : dangiSizes) {
      System.out.println(size);
    }
      
    }

    private static void dfs(int x, int y) {
      visited[x][y] = true;

      for ( int[] dir : directions) {
        int dx = dir[0];
        int dy = dir[1];

        int nx = x + dx;
        int ny = y + dy;

        if (0<= nx && nx < N && 0<= ny && ny < N && board[nx][ny] == 1) {
          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            dangi++;
            dfs(nx,ny);
        
          }
        }
      }
    }
} 