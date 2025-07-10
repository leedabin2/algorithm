import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    // 1 2 3  5 6 7

    int N = Integer.parseInt(br.readLine());

    int[][] line = new int[N][2];

    for (int i =0; i < N; i++) {
      String[] row = br.readLine().split(" ");

      line[i][0] = Integer.parseInt(row[0]);
      line[i][1] = Integer.parseInt(row[1]);
    }

    Arrays.sort(line, (a, b) -> {
    if (a[0] == b[0]) {
        return Integer.compare(a[1], b[1]); 
    }
        return Integer.compare(a[0], b[0]);  
    });


    int start = line[0][0], end = line[0][1];

    int total = 0;

    for (int i = 1; i < N; i++) {
      int x = line[i][0], y = line[i][1];

      if (x <= end) { // 겹친경우
        end = Math.max(end,y);

      } else { // 안 겹친 경우
        total += end - start;
        start = x;
        end = y;
      }
    }

    total += end - start;

    System.out.println(total);


  }
} 