import java.util.*;
import java.io.*;

class Main {
  static int n, m, k;
  static int[] dx = {0, -1, 1, 0,0};
  static int[] dy = {0, 0, 0, -1, 1};
  static Map<Integer, int[]> sharks = new HashMap<>(); // 상어번호 : [x, y, dir]
  static Map<Integer, int[][]> priority = new HashMap<>();
  static int[][] smellTime, smellOwner;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    n = Integer.parseInt(st[0]);
    m = Integer.parseInt(st[1]);
    k = Integer.parseInt(st[2]);

    smellOwner = new int[n][n];
    smellTime = new int[n][n];

    for (int i =0 ; i < n; i++) {
      String[] row = br.readLine().split(" ");
      for (int j =0; j < n; j++) {
        smellOwner[i][j] = Integer.parseInt(row[j]);
        if (smellOwner[i][j] != 0) {
          smellTime[i][j] = k;
          sharks.put(smellOwner[i][j], new int[]{i, j, 0});
        }
      }
    }

    String[] d = br.readLine().split(" ");
    for (int i = 1; i <=m; i++) {
      sharks.get(i)[2] = Integer.parseInt(d[i - 1]);
    }

    for (int s = 1; s <= m; s++) {
      int[][] p = new int[5][4];
      for (int dir = 1; dir <= 4; dir++) {
        String[] line = br.readLine().split(" ");
        for (int k2 = 0; k2 < 4; k2++) {
          p[dir][k2] = Integer.parseInt(line[k2]);
        }
      }
      priority.put(s, p);
    }

    int time = 0;
    while (time < 1000) {
      if (sharks.size() == 1) {
        System.out.println(time);
        return;
      }
      moveSharks();
      decreaseSmell();
      leaveSmell();
      time++;
    }

    if (sharks.size() == 1) {
      System.out.println(time);
    } else {
      System.out.println(-1);
    }
  }
  static private void moveSharks() {
    Map<Integer, int[]> next = new HashMap<>();

    List<Integer> order = new ArrayList<>(sharks.keySet());
    Collections.sort(order);

    for (int s : order) {
      int[] info = sharks.get(s);
      int x = info[0];
      int y = info[1];
      int dir  = info[2];

      int[][] pri = priority.get(s);

      boolean moved = false;


      // 냄새없는 칸 이동
      for (int d : pri[dir]) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
        if (smellOwner[nx][ny] == 0) {
          if (!isLowerSharkExists(next, s, nx, ny)) {
            next.put(s, new int[]{nx, ny, d});
          }
          moved = true;
          break;
        }
      }

      if (moved) continue;

      // 칸이 없으면 자기 냄새 있는 칸으로 이동
      for (int d : pri[dir]) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
        if (smellOwner[nx][ny] == s) {
           if (!isLowerSharkExists(next, s, nx, ny)) {
                next.put(s, new int[]{nx, ny, d});
            }
          
            break;
        }
      }
    }

    sharks = next;
 
  }
  static boolean isLowerSharkExists(Map<Integer, int[]> next, int cur, int nx, int ny) {
    for (int other : next.keySet()) {
      int[] info = next.get(other);
      if (info[0] == nx && info[1] == ny) {
        return other < cur;
      }
    }
    return false;
  }

  static void decreaseSmell() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (smellTime[i][j] > 0) {
          smellTime[i][j]--;
          if (smellTime[i][j] == 0) {
            smellOwner[i][j] = 0;
          }
        }
      }
    }
  }

  static void leaveSmell(){
    for (int s : sharks.keySet()) {
      int[] info = sharks.get(s);
      int x = info[0];
      int y = info[1];
      smellOwner[x][y] = s;
      smellTime[x][y] = k;
    }
  }
}
