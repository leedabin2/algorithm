import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Main {
  static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
  static List<List<List<Integer>>> board;
  static Deque<int[]> balls;
  static int N, M, K;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);
    K = Integer.parseInt(st[2]);

    board = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      board.add(new ArrayList<>());
      for (int j = 0; j < N; j++) board.get(i).add(new ArrayList<>());
    }

    balls = new ArrayDeque<>();
    for (int id = 0; id < M; id++) {
      String[] row = br.readLine().split(" ");
      int r = Integer.parseInt(row[0]) - 1;
      int c = Integer.parseInt(row[1]) - 1;
      int m = Integer.parseInt(row[2]);
      int s = Integer.parseInt(row[3]);
      int d = Integer.parseInt(row[4]);
      balls.add(new int[]{r, c, m, s, d});

    }

    while (K-- > 0) {
      moveFireBall();
      mergeFireBalls();

    }

     System.out.println(sumMass());
  }
  static void moveFireBall() {

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board.get(i).get(j).clear();
      }
    }

    Deque<int[]> newBalls = new ArrayDeque<>();
    
    int size = balls.size();
    for (int id =0; id < size; id++) {
      int[] b  = balls.poll();

      int r = b[0];
      int c = b[1];
      int m = b[2];
      int s = b[3];
      int d = b[4];

      int nr = (r + dx[d] * (s % N) + N) % N;
      int nc = (c + dy[d] * (s % N) + N) % N;

      board.get(nr).get(nc).add(newBalls.size()); // idx 저장
      newBalls.add(new int[]{nr, nc, m, s, d});
    }
    balls = newBalls;
  }
  static void mergeFireBalls(){
    Deque<int[]> newBalls = new ArrayDeque<>();
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        List<Integer> cell = board.get(r).get(c);
  
        if (cell.size() == 0) continue;

        if (cell.size() == 1) {
            int idx = cell.get(0);
            int[][] tempBalls = balls.toArray(new int[0][]);
            newBalls.add(tempBalls[idx]);
            continue;
        }
       
          int[][] tempBalls = balls.toArray(new int[0][]);

          int mass = 0;
          int speed = 0;
          boolean allEven = true;
          boolean allOdd = true;

          for (int idx : cell) {
            int[] b = tempBalls[idx];

            int m = b[2];
            int s = b[3];
            int d= b[4];

            mass += m;
            speed += s;
            if (d % 2 == 0) allOdd = false;
            else  allEven = false;
           
   
          }

          int newMass = (mass/5);
          if (newMass == 0) continue; 
          int newSpeed = (speed/cell.size());

          int[] dirs = (allEven || allOdd) ? new int[]{0,2,4,6} : new int[]{1,3,5,7};

          for (int d : dirs) {
              newBalls.add(new int[]{r, c, newMass, newSpeed, d});
          }
        
      }
      
    }
    balls = newBalls;
  }
  static int sumMass() {
    int sum = 0;
    while (!balls.isEmpty()) {
      int[] b = balls.poll();

      int m = b[2];
      sum += m;
    }
    return sum;
  }
}
