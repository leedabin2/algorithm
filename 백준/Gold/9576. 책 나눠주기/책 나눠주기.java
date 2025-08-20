import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    // 2 : 54
    int T = Integer.parseInt(br.readLine());

    for (int i = 0;i < T; i++) {
      String[] st = br.readLine().split(" ");

      int N = Integer.parseInt(st[0]);
      int M = Integer.parseInt(st[1]);

      boolean[] book = new boolean[N];
      for (int num = 0; num < N; num++) {
        book[num] = true;
      }

      int answer = 0;
      int[][] wait = new int[M][2];

      for (int j = 0; j < M; j++) {
        String[] row = br.readLine().split(" ");

        int a = Integer.parseInt(row[0]) - 1;
        int b = Integer.parseInt(row[1]) - 1;
        wait[j][0] = a;
        wait[j][1] = b;

      }


      // b기준 오름차순 정렬 
      Arrays.sort(wait, (a, b) -> {
        if (a[1] == b[1]) return a[0] - b[0];
        return a[1] - b[1];
      });

      for (int[] c : wait) {
        int ca = c[0], cb = c[1];

        for (int idx = ca; idx <= cb; idx++) {
          if (book[idx]) {
            book[idx] = false;
            answer++;
            break;
          }
        }
      }


      System.out.println(answer);
    }
  }
} 