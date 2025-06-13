import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  static Deque<int[]> houses;
  static List<int[]> chicken;
  static int answer = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    // [2,7], [6,1]
    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
    M = Integer.parseInt(st[1]);

    int[][] board = new int[N][N];

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(row[j]);

      }
    }

    houses = new ArrayDeque<>();
    chicken = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (board[i][j] == 1) {
          houses.add(new int[]{i+1,j+1}); // 집정보
        }
        if (board[i][j] == 2) {
          chicken.add(new int[]{i+1,j+1}); // 치킨집정보
        }
      }
    }

    dfs(new ArrayList<>(), 0);
    System.out.println(answer);
  }

  private static  void dfs(List<int[]> selected, int idx) {
    if (selected.size() == M) {
      int total  = 0;

      for (int[] house : houses) {
        int r1 = house[0];
        int c1 = house[1];

        int minDist = Integer.MAX_VALUE;

        for (int[] ch : selected ) {
          int r2 = ch[0];
          int c2 = ch[1];
          
          int diff = Math.abs(r1- r2) + Math.abs(c1 - c2);
          minDist = Math.min(diff, minDist); // 해당 집에서 여러 치킨집 중 가장 작은 거리
        
        }
        total += minDist;
    
      }

      answer = Math.min(total, answer);
      return;
    }

    for (int i = idx; i < chicken.size(); i++) {
      selected.add(chicken.get(i));
      dfs(selected, i +1);
      selected.remove(selected.size()-1);
    }
  }
} 









