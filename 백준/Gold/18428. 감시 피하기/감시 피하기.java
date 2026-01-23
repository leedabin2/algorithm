import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {
  static int N;
  static final int SIZE = 3;
  static boolean ishide = false;
  static char[][] board;
  static int[] dx = {0, -1, 0, 1};
  static int[] dy = {-1, 0, 1, 0};
  static List<int[]> blanks = new ArrayList<>();
  static List<int[]> teachers = new ArrayList<>();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());
      board = new char[N][N];

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          board[i][j] = row[j].charAt(0);
          if (board[i][j] == 'X') blanks.add(new int[]{i, j});
          if (board[i][j] == 'T') teachers.add(new int[]{i, j});
        }
      }

      dfs(0, new ArrayList<>());

      System.out.println(ishide ? "YES" : "NO");
   }
   static void dfs(int start, List<int[]> lst) {
    if (ishide) return;

    if (lst.size() == SIZE) {
      if (canHide(lst)) ishide = true;
      return;
    }

    for (int i = start; i < blanks.size(); i++) {
      int[] b = blanks.get(i);
      lst.add(b);
      dfs(i+1, lst);
      lst.remove(lst.size()-1);
    }
   }
   static boolean canHide(List<int[]> lst) {
    char[][] copyBoard = istall(copy(board), lst);

    for (int[] teacher : teachers) {
      int tx = teacher[0];
      int ty = teacher[1];

      for (int d = 0; d < 4; d++) {
        int nx = tx; 
        int ny = ty;

        while (true) {
          nx += dx[d];
          ny += dy[d];
          if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
          if (copyBoard[nx][ny] == 'O') break;
          if (copyBoard[nx][ny] == 'S') return false;
        }
      }
    }

    return true;
   }
   static char[][] copy(char[][] board) {
    char[][] copyBoard = new char[N][N];

    for (int i = 0; i < N; i++) {
      copyBoard[i] = board[i].clone();
    }

    return copyBoard;
   }
   static char[][] istall(char[][] copyBoard, List<int[]> lst) {

    for (int[] blank : lst) {
      int x = blank[0]; int y = blank[1];
      copyBoard[x][y] = 'O';
    }

    return copyBoard;
   }
}