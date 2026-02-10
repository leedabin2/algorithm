import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      String[] input = br.readLine().split(" ");
      int n = Integer.parseInt(input[0]);
      int k = Integer.parseInt(input[1]);
      int t = Integer.parseInt(input[2]);
      int m = Integer.parseInt(input[3]);

      int[] totalScore = new int[n+1]; // 최종점수
      int[][] best = new int[n+1][k+1]; // 팀번호 -> 최고점수
      int[] submitCnt = new int[n+1];
      int[] lastSubmit = new int[n+1];


      for (int log =0 ; log < m; log++) {
        String[] info = br.readLine().split(" ");
        int i = Integer.parseInt(info[0]);
        int j = Integer.parseInt(info[1]);
        int s = Integer.parseInt(info[2]);
        
        submitCnt[i]++;
        lastSubmit[i] = log;

        best[i][j] = Math.max(best[i][j], s);
      }

      // 총점 꼐산
      for (int team = 1; team <= n; team++) {
        int sum = 0;
        for (int p = 1; p <= k; p++) {
          sum += best[team][p];
        }
        totalScore[team] = sum;
      }

      // 팀번호 리스트
      List<Integer> teams = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        teams.add(i);
      }

      // 총점 내림차순, 제출횟수 오름차순, 제출로그 오름차순
      Collections.sort(teams, (a, b) -> {
        if (totalScore[a] != totalScore[b]) return totalScore[b] - totalScore[a];
        if (submitCnt[a] != submitCnt[b]) return submitCnt[a] - submitCnt[b];
        return lastSubmit[a] - lastSubmit[b];
      });

      // 등수출력
      for (int i = 0; i < teams.size(); i++) {
        if (teams.get(i) == t) {
          System.out.println(i+1);
          break;
        }
      }
    }
   }
}