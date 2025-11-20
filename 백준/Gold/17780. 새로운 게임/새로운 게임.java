import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {
  static final int[] dx = {0, 0, 0, -1, 1};
  static final int[] dy = {0, 1, -1, 0, 0};
  static int n, k;
  static List<List<List<Integer>>> board;
  static int[][] color, pieces;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    n = Integer.parseInt(st[0]);
    k = Integer.parseInt(st[1]);

    color = new int[n][n];
    for (int i = 0; i < n; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < n; j++) color[i][j] = Integer.parseInt(row[j]);
    }

    board = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      board.add(new ArrayList<>());
      for (int j = 0; j < n; j++) board.get(i).add(new ArrayList<>());
    }

    pieces = new int[k + 1][3]; // [r,c,dir]
    for (int id = 1; id <= k; id++) {
      String[] row = br.readLine().split(" ");
      int r = Integer.parseInt(row[0]) - 1;
      int c = Integer.parseInt(row[1]) - 1;
      int dir = Integer.parseInt(row[2]);
      pieces[id][0] = r;
      pieces[id][1] = c;
      pieces[id][2] = dir;
      board.get(r).get(c).add(id);
    }

    int turn = 0;
    while (turn++ < 1000) {
      if (moveHorses()) {
        System.out.println(turn);
        return;
      }
    }
    System.out.println(-1);
  }

  static boolean moveHorses() {
    for (int id = 1; id <= k; id++) {
      int r = pieces[id][0];
      int c = pieces[id][1];
      int dir = pieces[id][2];

      List<Integer> cur = board.get(r).get(c);
      if (cur.get(0) != id) continue;  // 맨 아래가 아니면 건너뛰기

      int nr = r + dx[dir];
      int nc = c + dy[dir];

      if (isBlue(nr, nc)) {
        dir = reverse(dir);
        pieces[id][2] = dir;
        nr = r + dx[dir];
        nc = c + dy[dir];
        if (isBlue(nr, nc)) continue;
      }

      moveStack(id, r, c, nr, nc, color[nr][nc] == 1);
      if (board.get(nr).get(nc).size() >= 4) return true;
    }
    return false;
  }

  static void moveStack(int id, int r, int c, int nr, int nc, boolean isRed) {
    List<Integer> cur = board.get(r).get(c);
    List<Integer> next = board.get(nr).get(nc);

    // id 가 시작되는 위치 찾기
    int startIdx = cur.indexOf(id);

    // 이동 대상 스택 분리
    Deque<Integer> moving = new ArrayDeque<>();
    for (int i = startIdx; i < cur.size(); i++) moving.add(cur.get(i));

    // 원래 위치에서 제거
    cur.clear();

    if (isRed) {
      while (!moving.isEmpty()) {
        int pid = moving.pollLast();
        next.add(pid);
        pieces[pid][0] = nr;
        pieces[pid][1] = nc;   
      }
    } else {
      // 이동할 칸 말위에 쌓아올리기
      while (!moving.isEmpty()) {
        int pid = moving.poll();
        next.add(pid);
        pieces[pid][0] = nr;
        pieces[pid][1] = nc;
      }
    }


  }

  static boolean isBlue(int r, int c) {
    return r < 0 || c < 0 || r >= n || c >= n || color[r][c] == 2;
  }

  static int reverse(int dir) {
    if (dir == 1) return 2;
    if (dir == 2) return 1;
    if (dir == 3) return 4;
    return 3;
  }
}
