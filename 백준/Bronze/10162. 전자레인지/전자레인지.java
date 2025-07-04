import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    int[] button = {300,60,10};
    int[] count = new int[3];

    if (T % 10 != 0) {
      System.out.println(-1);
      return;
    }

    for (int i = 0; i < 3; i++) {
      count[i] = T / button[i];
      T %= button[i];
    }

    System.out.println(count[0] + " " + count[1] + " " + count[2]);
    
  }
} 