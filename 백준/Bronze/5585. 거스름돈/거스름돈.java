import java.io.*;
import java.util.*;

class Main {
  static final int PAY = 1000;
  static int[] money = new int[]{500, 100, 50, 10, 5, 1};
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int pay = Math.abs(PAY-Integer.parseInt(br.readLine()));

    int ans = 0;

    for (int i = 0; i < money.length; i++) {
      int m = money[i];
      if (pay >= m) {
        int count = pay / m; // 동전 개수
        ans += count;
        pay -= count * m; // 금액차감
      }
    }

    System.out.println(ans);

   }
}