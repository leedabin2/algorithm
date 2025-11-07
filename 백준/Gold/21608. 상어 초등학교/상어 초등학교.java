import java.util.*;
import java.io.*;

class Main {
  static int[][] board;
  static Map<Integer, Set<Integer>> likeMap;
  static int n;
  static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; // 상하좌우

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    board = new int[n][n];

    likeMap = new HashMap<>();
    List<Integer> order = new ArrayList<>();

    for (int i = 0; i < n*n; i++) {
      String[] st = br.readLine().split(" ");
      int num = Integer.parseInt(st[0]);
      order.add(num);
      Set<Integer> likes = new HashSet<>();
      for (int j = 1; j < st.length; j++) {
        likes.add(Integer.parseInt(st[j]));
        
      }
      likeMap.put(num,likes);
    }

    for (int student : order) {
      putStudent(student);
    }

    System.out.println(getAnswer());
  }

  private static void putStudent(int student) {
    int bestR = -1, bestC = -1;
    int maxLike = -1, maxEmpty = -1;
    
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] != 0) continue;

        int likeCnt = 0;
        int emptyCnt = 0;

        for (int[] d : directions) {
          int nr = d[0] + r, nc = d[1] + c;
          if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

          if (likeMap.get(student).contains(board[nr][nc])) likeCnt++;
          else if (board[nr][nc] == 0) emptyCnt++;
        }

        if (likeCnt > maxLike ||
        (likeCnt == maxLike && emptyCnt > maxEmpty) ||
        (likeCnt == maxLike && emptyCnt == maxEmpty && (r < bestR || bestR == -1)) ||
        (likeCnt == maxLike && emptyCnt == maxEmpty && (c < bestC || bestC == -1))) {
          maxLike = likeCnt;
          maxEmpty = emptyCnt;
          bestR = r;
          bestC = c;
        }
      }
    }

    board[bestR][bestC] = student;
  }

  private static int getAnswer() {

    int total = 0;
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        int student = board[r][c];

        int likeCnt = 0;

        for (int[] d : directions) {
          int nr = d[0] + r, nc = d[1] + c;
          if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

          if (likeMap.get(student).contains(board[nr][nc])) likeCnt++;
        }

        if (likeCnt > 0) total += (int) Math.pow(10, likeCnt-1);
      }
    }

    return total;
  }
}
