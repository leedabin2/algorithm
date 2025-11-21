import java.io.*;
import java.util.*;

class Main {
  static int[] dx = new int[]{0, 0, 0, -1, 1};
  static int[] dy = new int[]{0, 1, -1, 0, 0};
  static int N, K;
  static int[][] colors, pieces;
  static List<List<List<Integer>>> board = new ArrayList<>();
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N =Integer.parseInt(st[0]);
    K = Integer.parseInt(st[1]);

    pieces = new int[K+1][3];
    colors = new int[N][N];
    for (int i = 0; i < N; i++) {
      board.add(new ArrayList<>());
      for (int j = 0; j < N; j++) {
        board.get(i).add(new ArrayList<>());
      }
    }

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        colors[i][j] = Integer.parseInt(row[j]);
      }
    }

    for (int id = 1; id <= K; id++) {
      String[] info = br.readLine().split(" ");
      int r = Integer.parseInt(info[0])-1;
      int c = Integer.parseInt(info[1])-1;
      int d = Integer.parseInt(info[2]);

      board.get(r).get(c).add(id);
      pieces[id][0] = r;
      pieces[id][1] = c;
      pieces[id][2] = d;
    }

    int turn = 0;
    while (turn < 1000) {

      if (moveHorses()) {
        System.out.println(turn + 1);
        return;
      }

      turn++;
      
    }
    System.out.println(-1);
  }
  static boolean moveHorses() {
    for (int id = 1; id <= K; id++) {
      int[] h = pieces[id];
      int r = h[0];
      int c = h[1];
      int d = h[2];

      List<Integer> cell = board.get(r).get(c);
      int startIdx = cell.indexOf(id);
      if (startIdx == -1) continue;

      int nr = r + dx[d];
      int nc = c + dy[d];

      if (isBlue(nr, nc)) {
        d = reverseDir(d);
        pieces[id][2] = d;
        nr = r + dx[d];
        nc = c + dy[d];
        if (isBlue(nr, nc)) {
          continue;
        }
      }

      moveStack( startIdx, r, c, nr, nc, colors[nr][nc] == 1);

      if (board.get(nr).get(nc).size() >= 4) return true;

    }
    return false;
  }
  static void moveStack(int startIdx, int x, int y, int nx, int ny, boolean isRed) {

    List<Integer> next = board.get(nx).get(ny);
    List<Integer> cur = board.get(x).get(y);


    Deque<Integer> moving = new ArrayDeque<>();
    for (int i = startIdx; i < cur.size(); i++) {
      moving.add(cur.get(i));
    }
    cur.subList(startIdx, cur.size()).clear();


    if (isRed) {
      while (!moving.isEmpty()) {
        int pid = moving.pollLast();
        next.add(pid);
        pieces[pid][0] = nx;
        pieces[pid][1] = ny;
        
      }
    } else {
      while (!moving.isEmpty()) {
        int pid = moving.poll();
        next.add(pid);
        pieces[pid][0] = nx;
        pieces[pid][1] = ny;
      }
    }


  }
  static boolean isBlue(int r, int c) {
      return r < 0 || r >= N || c < 0 || c >= N || colors[r][c] == 2;
  }
  static int reverseDir(int d) {
    if (d == 2) return 1;
    else if (d == 1) return 2;
    else if (d == 3) return 4;
    return 3;
  }
  
}
