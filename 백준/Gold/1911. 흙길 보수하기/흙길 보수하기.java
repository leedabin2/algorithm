import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int N = Integer.parseInt(st[0]);
    int L = Integer.parseInt(st[1]);

    int min = 0;

    long[][] pong = new long[N][2];

    for (int i = 0; i < N; i++) {
      String[] info = br.readLine().split(" ");

      long start = Long.parseLong(info[0]);
      long end = Long.parseLong(info[1]); 

      pong[i][0] = start;
      pong[i][1] = end;

    }

    Arrays.sort(pong, (a, b) -> {
      if (a[0] != b[0]) return Long.compare(a[0], b[0]);
      return Long.compare(a[1], b[1]);
    });
    long pos = 0;
    int answer = 0;

    for (int i = 0; i < N; i++) {
      long start = pong[i][0];
      long end = pong[i][1];
      if (pos < start) {
        pos = start;
      }

      while (pos < end) {
        pos += L;
        answer++;
      }
    }
    
    System.out.println(answer);
   }
}