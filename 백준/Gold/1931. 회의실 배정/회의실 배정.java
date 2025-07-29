import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] times = new int[N][2];

    for (int i = 0; i < N; i++) {
      String[] row = br.readLine().split(" ");

      int start = Integer.parseInt(row[0]);
      int end = Integer.parseInt(row[1]);

      times[i][0] = start;
      times[i][1] = end;

    }

    Arrays.sort(times, (a, b) -> {
      if (a[1] == b[1]) return a[0] - b[0];
      else return a[1] - b[1];
      
      });

    int count = 0;
    int endTime = 0;

    for (int[] time : times) {
      int start = time[0];
      int end = time[1];

      if (start >= endTime) {
        count++;
        endTime = end;
      }
    }


    System.out.println(count);


  }
} 