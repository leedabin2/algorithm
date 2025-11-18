import java.util.*;
import java.io.*;

class Main {
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, -1, 0, 1};
  static boolean[][] map = new boolean[101][101];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
        String[] line = br.readLine().split(" ");
        int x = Integer.parseInt(line[0]);
        int y = Integer.parseInt(line[1]);
        int d = Integer.parseInt(line[2]);
        int g = Integer.parseInt(line[3]);

        dragonCurve(x, y, d, g);
    }

    System.out.println(countSquares());
  }
  static void dragonCurve(int x, int y, int d, int g) {
    List<Integer> dirs = new ArrayList<>();
    dirs.add(d);
    for (int gen = 1; gen <= g; gen++) {
      for (int i = dirs.size()-1; i >=0; i--) {
        dirs.add((dirs.get(i) + 1) % 4);
      }
    }

    map[y][x] = true;

    for (int dir : dirs) {
      x += dx[dir];
      y += dy[dir];

      if (0 <= x && x <= 100 && 0 <= y && y <= 100) {
          map[y][x] = true;
      }
    }
  }
  static int countSquares() {
    int cnt = 0;
    for (int y = 0; y < 100; y++) {
      for (int x = 0; x < 100; x++) {
        if (map[y][x] && 
        map[y][x+1] &&
        map[y+1][x] &&
        map[y+1][x+1]) {
          cnt++;
        }
      }
    }
    return cnt;
    
  }
}
