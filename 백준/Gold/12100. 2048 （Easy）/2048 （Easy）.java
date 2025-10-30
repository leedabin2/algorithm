import java.util.*;
import java.io.*;

class Main {
  static int[][] board;
  static int n;
  static int t = 5;
  static int answer = -1;
  static int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      n = Integer.parseInt(br.readLine());
      board = new int[n][n];

      for (int i = 0; i < n; i++) {
        String[] st = br.readLine().split(" ");

        for (int j = 0; j < n; j++) {
          board[i][j] = Integer.parseInt(st[j]);
        }
      }

      dfs(0, board);
      System.out.println(answer);
    }

    private static void dfs(int depth, int[][] map) {
      if (depth == t) {
        for (int[] m : map) {
          for (int r : m) {
            answer = Math.max(answer, r);
          }
        }
        return;
      }

      for (int d = 0; d < 4; d++) {
        int[][] next = move(d, copy(map));
        dfs(depth+1, next);
      }
    }

    private static int[][] move(int dir, int[][] map) {
      // 상
      if (dir == 0) {
        for (int c = 0; c < n; c++) {
          int[] temp = new int[n];
          int idx = 0;
          for (int r = 0; r < n; r++) {
            if (map[r][c] == 0) continue;
            int val = map[r][c];
            map[r][c] = 0;
            if (temp[idx] == 0) temp[idx] = val;
            else if (temp[idx] == val) temp[idx++] *= 2;
            else temp[++idx] = val;
          }
          for (int r = 0; r < n; r++) {
            map[r][c] = temp[r];
          }
        }
      } else if (dir == 1) {
        for (int c = 0; c < n; c++) {
          int[] temp = new int[n];
          int idx = n-1;

          for (int r = n-1; r >= 0; r--) {
            if (map[r][c] == 0) continue;
            int val = map[r][c];
            map[r][c] = 0;
            if (temp[idx] == 0) temp[idx] = val;
            else if (temp[idx] == val) temp[idx--] *= 2;
            else temp[--idx] = val; 
          }
          for (int r = n-1; r >= 0; r--) {
            map[r][c] = temp[r];
          }
        }
      } else if (dir == 2) {
        for (int r =0; r < n; r++) {
          int[] temp = new int[n];
          int idx = 0;

          for (int c = 0; c < n; c++) {
            if (map[r][c] == 0) continue;
            int val = map[r][c];
            map[r][c] = 0;
            if (temp[idx] == 0) temp[idx] = val;
            else if (temp[idx] == val) temp[idx++] *= 2;
            else temp[++idx] = val; 
          }
          for (int c = 0; c < n; c++) {
            map[r][c] = temp[c];
          }
        }
      } else if (dir == 3) {
        for (int r = 0; r < n; r++) {
          int[] temp = new int[n];
          int idx = n-1;
          for (int c = n-1; c >= 0; c--) {
            if (map[r][c] == 0) continue;
            int val = map[r][c];
            if (temp[idx] == 0) temp[idx] = val;
            else if (temp[idx] == val) temp[idx--] *= 2;
            else temp[--idx] = val;
          }
          for (int c = 0; c < n; c++) {
            map[r][c] = temp[c];
          }
        }
      }
      return map;
    }
    private static int[][] copy(int[][] map) {
      int[][] copyMap = new int[n][n];

      for (int i = 0; i < n; i++) {
        copyMap[i] = Arrays.copyOf(map[i], n);
      }
      return copyMap;
    }
      
}