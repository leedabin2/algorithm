import java.io.*;
import java.util.*;

class Main {
  static Map<String, int[]> dir = Map.of(
    "R", new int[]{0, 1},   // 오른쪽 
    "L", new int[]{0, -1},  // 왼쪽 
    "B", new int[]{-1, 0},  // 아래 
    "T", new int[]{1, 0},   // 위
    "RT", new int[]{1, 1},  // 오른쪽 위
    "LT", new int[]{1, -1}, // 왼쪽 위
    "RB", new int[]{-1, 1}, // 오른쪽 아래
    "LB", new int[]{-1, -1} // 왼쪽 아래
);
  static int m = 8;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String[] cmd = br.readLine().split(" ");

    String king = cmd[0];  
    int kx = king.charAt(1) - '1';
    int ky = king.charAt(0) - 'A';

    String rock = cmd[1];  
    int rx = rock.charAt(1) - '1';
    int ry = rock.charAt(0) - 'A';

    int n = Integer.parseInt(cmd[2]);


    for (int i =0; i < n; i++) {
      String move = br.readLine();

      int[] d = dir.get(move);
      int nx = d[0] + kx;
      int ny = d[1] + ky;

      if (!isRange(nx, ny)) continue;
      if (nx == rx && ny == ry) {
        // 이동할 곳에 돌이 있을 경우
        int nrx = d[0] + rx;
        int nry = d[1] + ry;
        
        if (!isRange(nrx, nry)) continue;

        rx = nrx;
        ry = nry;

      } 
      kx = nx;
      ky = ny;
    }

    System.out.println("" + (char)(ky + 'A') + (kx + 1));
    System.out.println("" + (char)(ry + 'A') + (rx + 1));

 
  }
  static boolean isRange(int x, int y) {
    return 0 <= x && x < m && 0 <= y && y < m;
  }
}