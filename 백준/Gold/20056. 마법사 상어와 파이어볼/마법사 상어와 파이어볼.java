import java.io.*;
import java.util.*;

class Main {
  static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
  static List<List<List<Integer>>> board = new ArrayList<>();
  static List<int[]> balls = new ArrayList<>();
  static int N, M, K;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    K = Integer.parseInt(st[2]);

    for (int i = 0; i < N; i++){
      board.add(new ArrayList<>());
      for (int j = 0; j < N; j++) {
        board.get(i).add(new ArrayList<>());
      }
    }

    for (int i = 0; i < M; i++) {
      String[] info  = br.readLine().split(" ");
      int r = Integer.parseInt(info[0]);
      int c = Integer.parseInt(info[1]);
      int m = Integer.parseInt(info[2]);
      int s = Integer.parseInt(info[3]);
      int d = Integer.parseInt(info[4]);

      balls.add(new int[]{r, c, m, s, d});
    }

    while (K-- > 0) {
      moveFireBalls();
      mergeFireBalls();
      
    }
    System.out.println(sumMass());
    
  }
  static void moveFireBalls() {
    for (int i =0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board.get(i).get(j).clear();
      }
    }

    List<int[]> newBalls = new ArrayList<>();

    for (int i = 0; i < balls.size(); i++) {
      int[] b = balls.get(i);

      int r = b[0];
      int c = b[1];
      int m = b[2];
      int s = b[3];
      int d = b[4];

      int nr = (r + dx[d] * (s % N) + N) % N;
      int nc = (c + dy[d] * (s % N) + N) % N;

      newBalls.add(new int[]{nr, nc, m, s, d});
      board.get(nr).get(nc).add(i);

    }
    balls = newBalls;

  }
  static void mergeFireBalls() {
    List<int[]> newBalls = new ArrayList<>();
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {

        List<Integer> cell = board.get(r).get(c);

        if (cell.size() == 0) continue;

        if (cell.size() == 1) {
          int[] b = balls.get(cell.get(0));
          newBalls.add(b);
          continue;
        }

        int mass = 0;
        int speed = 0;
        boolean allAdd = true;
        boolean allEven = true;

        for (int id : cell) {
          int[] b = balls.get(id);
          
          int m = b[2];
          int s = b[3];
          int d = b[4];

          mass += m;
          speed += s;

          if (d % 2 == 0) {
            allAdd = false;
          } else allEven = false;

        }

        int newMass = (mass/5);
        if (newMass == 0) continue;
        int newSpeed = (speed/cell.size());

        int[] dirs = (allAdd || allEven) ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5,7};

        for (int d : dirs) {
          newBalls.add(new int[]{r, c, newMass, newSpeed, d});
        }
      }
    }

    balls = newBalls;
  }
  static int sumMass() {
    int sum = 0;
    for (int[] b : balls) {
      int m = b[2];
      sum += m;
    }
    return sum;
  }
}
