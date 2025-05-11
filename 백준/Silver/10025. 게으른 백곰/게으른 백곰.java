import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);
    
    int maxX = 0;
    List<int[]> iceInfo = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split(" ");
      int ice = Integer.parseInt(line[0]);
      int x = Integer.parseInt(line[1]);

      iceInfo.add(new int[]{ice, x});
      maxX = Math.max(maxX, x);

    }

    int[] bucket = new int[maxX + 1];

    for (int[] info : iceInfo) {
      int ice = info[0];
      int x = info[1];

      bucket[x] = ice;
    }

    int sum = 0;
    int range = Math.min(maxX, 2*K);
    for (int i = 0; i <= range; i++) {
      sum += bucket[i];
    }

    int max = sum;

    for (int i = range + 1; i <= maxX; i++) {
      sum = sum - bucket[i-range-1] + bucket[i];
      if (max < sum) max = sum;
    }

    System.out.println(max);
  }
}