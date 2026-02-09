import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int[][] board;
  static boolean[] teams;
  static int minDiff = Integer.MAX_VALUE;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());
      board = new int[N][N];

      for (int i = 0; i < N; i++) {
        String[] st = br.readLine().split(" ");
        for (int j = 0; j < N; j++) {
          board[i][j] = Integer.parseInt(st[j]);
        }
      }

      teams = new boolean[N];
      
      teamComb(0, new ArrayList<>()); // 스타트팀, 링크팀 콤비

      System.out.println(minDiff);


   }
   static int total(int start, List<Integer> comb, List<Integer> lst) {
    if (comb.size() == 2) {
      return power(comb.get(0), comb.get(1));
    }

    int sum = 0;
    for (int i = start; i < lst.size(); i++) {
      comb.add(lst.get(i));
      sum += total(i+1, comb, lst);
      comb.remove(comb.size()-1);
    }

    return sum;
   }
   static void minPower(boolean[] combi) {
    // 3 명 1 , 2, 3  | 4 5 6 
    List<Integer> start = new ArrayList<>();
    List<Integer> link = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      if (teams[i]) start.add(i);
      else link.add(i);
    }

    int startTeam = total(0, new ArrayList<>(), start);
    int linkTeam = total(0, new ArrayList<>(), link);

    minDiff = Math.min(minDiff, Math.abs(startTeam - linkTeam));
   }
   static void teamComb(int start, List<Integer> team) {
    if (team.size() == N/2) {
      Arrays.fill(teams, false); // 초기화
      for (int t : team) {
        teams[t] = true; // 스타트팀
      }
      // 능력치 구하기
      minPower(teams);
      return;
    }

    for (int i = start; i < N; i++) {
      team.add(i);
      teamComb(i+1, team);
      team.remove(team.size()-1);
    }
   }
   static int power(int a, int b) {
    return board[a][b] + board[b][a];
   }
}