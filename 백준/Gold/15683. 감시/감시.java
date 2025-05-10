import java.util.*;
import java.io.*;

class Main {
  static boolean[][] visited;
  static int[][] board;
  static int N, M;
  static int min;
  static int[] dx, dy;
  static List<int[]> cctvs = new ArrayList<>();
  static int[][][] directions;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    min = Integer.MAX_VALUE;
    board = new int[N][M];
    visited = new boolean[N][M];
    dx = new int[]{-1,1,0,0}; // 상 하 우 좌
    dy = new int[]{0,0,1,-1};
    directions = new int[][][]{
      {},
      {{0},{1},{2},{3}},
      {{0,1},{2,3}},
      {{0,2},{2,1},{3,1},{3,0}},
      {{0,2,3},{0,1,2},{1,2,3},{0,3,1}},
      {{0,1,2,3}}
    };

    for (int i = 0; i < N;i++) {
      String[] l = br.readLine().split(" ");
      for (int j = 0;j < M; j++) {
        board[i][j] = Integer.parseInt(l[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (1 <= board[i][j] && board[i][j] <= 5 ) {
          cctvs.add(new int[]{i,j,board[i][j]});       
        }
      }
    }

    dfs(0, board);
    System.out.print(min);


  }
  static void dfs(int depth, int[][] map) {
    if (depth == cctvs.size()) {
      min = Math.min(min,countWidth(map));
      return;
    }

    int[] cctv = cctvs.get(depth);
    int x = cctv[0];
    int y = cctv[1];
    int num = cctv[2];

    for (int[] dirs : directions[num]) {
      int[][] copy = copyMap(map);
      for (int d : dirs) {
        int nx = x;
        int ny = y;
        while(true) {
          nx += dx[d];
          ny += dy[d];
          if (nx < 0 || nx >= N || 0 > ny || ny >= M || copy[nx][ny] == 6) break;

          if(copy[nx][ny] == 0) copy[nx][ny] = 7;
          
        }
      }
      dfs(depth+1,copy);
    }
  }

  static int countWidth(int[][] map) {
    int count = 0;
    for (int[] row : map) {
      for (int val : row) {
        if (val == 0) count++;
      }
    }
    return count;
  }

  static int[][] copyMap(int[][] map) {
    int[][] newMap = new int[N][M];
    for (int i = 0; i < N;i++) {
      newMap[i] = Arrays.copyOf(map[i],M);

    }
    return newMap;
  }
}