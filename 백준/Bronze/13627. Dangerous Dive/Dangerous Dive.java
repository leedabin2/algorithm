import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] input = br.readLine().split(" ");

      int N = Integer.parseInt(input[0]);
      int R = Integer.parseInt(input[1]);

      int[] back = new int[N];
      String[] st = br.readLine().split(" ");
      for (int i = 0; i < R; i++) {
        back[i] = Integer.parseInt(st[i]);
      }
  
      boolean[] isBroken = new boolean[N+1];
      for (int b : back) {
        isBroken[b] = true;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= N; i++) {
        if (!isBroken[i]) {
          sb.append(i).append(" ");
        }
      }

      if (sb.length() == 0) System.out.println("*");
      else System.out.println(sb);
   }
}