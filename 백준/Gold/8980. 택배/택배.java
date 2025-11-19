import java.util.*;
import java.io.*;


class Main {
  static int n, c, m;
  static int[][] info;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    n = Integer.parseInt(st[0]); 
    c = Integer.parseInt(st[1]); 

    m = Integer.parseInt(br.readLine()); 
    info = new int[m][3];
    for (int i = 0; i < m; i++) {
      String[] line = br.readLine().split(" ");
      info[i][0] = Integer.parseInt(line[0]); 
      info[i][1] = Integer.parseInt(line[1]); 
      info[i][2] = Integer.parseInt(line[2]); 
    }

    // 도착 오름차순, 같으면 출발 오름차순
    Arrays.sort(info, (a, b) -> {
      if (a[1] != b[1]) return a[1] - b[1];
      return a[0] - b[0];
    });

    int[] remain = new int[n+1];
    Arrays.fill(remain, c);

    int answer = 0;

    for (int[] box : info) {
      int from = box[0];
      int to = box[1];
      int cnt = box[2];

      int canDeliver = cnt;
      for (int i = from; i < to; i++) {
        canDeliver = Math.min(canDeliver, remain[i]);
      }

      if (canDeliver == 0) continue;

      for (int i = from; i < to; i++) {
        remain[i] -= canDeliver;
      }

      answer += canDeliver;
    }


    System.out.println(answer);
  }
}
