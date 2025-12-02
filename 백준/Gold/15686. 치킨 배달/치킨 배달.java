import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static int answer = Integer.MAX_VALUE;
  static List<int[]> houses = new ArrayList<>();
  static List<int[]> chickens = new ArrayList<>();
  static boolean[] selected;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);

      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          int d = Integer.parseInt(row[j]);
          if (d == 1) houses.add(new int[]{i, j}); // 집
          else if (d == 2) chickens.add(new int[]{i, j}); // 치킨
        }
      }

      selected = new boolean[chickens.size()];
      dfs(0, 0); 

      System.out.println(answer);

   }
   static void dfs(int start, int depth) {
    if (depth == M) {
      answer = Math.min(answer, calc() );
      return;
    }

    for (int i = start; i < chickens.size(); i++) {
      selected[i] = true;
      dfs(i + 1, depth +1);
      selected[i] = false;
    }
   }
   static int calc() {
    int sum = 0;

    for (int[] house : houses) {
      int r1 = house[0];
      int c1 = house[1];

      int minDist = Integer.MAX_VALUE;
      for (int i = 0; i < chickens.size(); i++) {
        if (selected[i]) {
          int[] ck = chickens.get(i);
          int r2 = ck[0];
          int c2 = ck[1];

          int dist = Math.abs(r1 - r2) + Math.abs(c1 -c2);
          minDist = Math.min(minDist, dist);
        }
      }

      sum += minDist;
    }
    return sum;
   }
}