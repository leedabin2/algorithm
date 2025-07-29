import java.util.*;
import java.io.*;

class Main {
  static int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
  static Set<int[]> unitedNations;
  static int N, L, R, answer = 0;
    static int[][] board;
    static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    // 상하좌우의 차이가 L 명 이상 R 명이하 -> 각 r,c 를 저장 공유(연합개수 증가)
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    L = Integer.parseInt(st[1]);
    R = Integer.parseInt(st[2]);

    board = new int[N][N];

    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(row[j]);
      }
    }
    

    while(true) {
      visited = new boolean[N][N];

      boolean moved = false;

      for (int i =0; i < N; i++) {
        for (int j =0; j < N; j++) {
          if (!visited[i][j]) {
            List<int[]> union = bfs(i, j);
            if (union.size() > 1) {
              check(union);
              moved = true;
            }
          }
        }
      }

      if (!moved) break;
      answer++;
    }

    System.out.println(answer);
  }
  static List<int[]> bfs(int x, int y) {
    Deque<int[]> queue= new ArrayDeque<>();
    List<int[]> union = new ArrayList<>();
    queue.add(new int[]{x,y});
    union.add(new int[]{x, y});
    visited[x][y] = true;

    while(!queue.isEmpty()) {
      int[] curr = queue.poll();

      int cx = curr[0], cy = curr[1];

      for (int[] dir : directions) {
        int nx = dir[0] + cx;
        int ny = dir[1] + cy;

        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
          int nextNation = board[nx][ny];
          int diffPopulation = Math.abs(board[cx][cy] - nextNation);
          if (L <= diffPopulation && diffPopulation <= R) {
            queue.add(new int[]{nx, ny});
            union.add(new int[]{nx, ny});
            visited[nx][ny] = true;
          }
        }
      }

    }
    return union;
  }

  static void check(List<int[]> union) {
    int unitedSize = union.size();
    int unitedSum = 0;
    for (int[] united : union) {
      unitedSum += board[united[0]][united[1]];
    }

    int diff = (int) Math.floor(unitedSum / unitedSize);
    
    for (int[] united : union) {
      int x = united[0];
      int y = united[1];

      board[x][y] = diff;
    }
 
  }
} 