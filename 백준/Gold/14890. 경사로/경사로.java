import java.io.*;

class Main {
  static int N, L;
  static int[][] board;
  static int answer;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[0]);
      L = Integer.parseInt(st[1]);

      board = new int[N][N];

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          board[i][j] = Integer.parseInt(row[j]);
        }
      }

      // 가로 부터 
      for (int i = 0; i < N; i++) {
        if (checkRow(i)) answer++;
      }

      // 세로
      for (int j = 0; j < N; j++) {
        if (checkCol(j)) answer++;
      }

      System.out.println(answer);


   }
   static boolean checkRow(int row) {
    boolean[] used = new boolean[N];
    for (int col = 0; col < N-1; col++) {
      int curr = board[row][col];
      int next = board[row][col+1];

      if (curr == next) continue;

      // 높이 1이상 차이라면 불가능
      if (Math.abs(curr-next) > 1) return false;

      // 오른쪽이 1낮으면 오른쪽 방향으로 경사로 설치
      if (curr - next == 1) {
        if (!put(row, col + 1, next, used, true)) return false;
      }

      // 왼쪽이라면 왼쪽 방향으로 경사로 설치
      if (curr - next == -1) {
        if (!put(row, col-L + 1, curr, used, true)) return false;
      }
    }
    return true;
   }

   static boolean checkCol(int col) {
    boolean[] used = new boolean[N];

    for (int row = 0; row < N-1; row++) {
      int curr = board[row][col];
      int next = board[row + 1][col];

      if (curr == next) continue;

      if (Math.abs(curr - next) > 1) return false;

      // 오름막으로 설치하는 경우
      if (curr - next == 1) {
        if (!put(row + 1, col, next, used, false)) return false;
      }

      // 내림막으로 설치하는 경우
      if (curr - next == -1) {
        if (!put(row-L + 1, col, curr, used, false)) return false;
      } 
    }

    return true;
   }

   // isRow: true → 가로 / false → 세로
   static boolean put(int x, int y, int height, boolean[] used, boolean isRow) {
    // L 길이 만큼 설치
    for (int k = 0; k < L; k++) {
      int r = isRow ? x : x + k;
      int c = isRow ? y + k : y;

      if (r < 0 || c < 0 || r >= N || c >= N) return false;

      // 높이 안 맞으면 불가
      if (board[r][c] != height) return false;

      // 이미 경사로가 되어있는지 체크
      if (used[isRow ? c : r]) return false;
    }

    for (int k = 0; k < L; k++) {
      int idx = isRow ? y + k : x + k;
      used[idx] = true;
    }

    return true;
   }
}