
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int cnt = 0;

        while(true) {
          if (String.valueOf(num).contains("666")) {
            cnt++;
            if (cnt == n) {
              System.out.println(num);
              break;
            }
          }
          num++;
        }
    }
}
