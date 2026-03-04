import java.io.*;
import java.util.*;

class Main {

   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {

      int n = Integer.parseInt(br.readLine());
      String[] numbers = new String[n];
      boolean possible = true;

      for (int i = 0; i < n; i++) {
        numbers[i] = br.readLine();
      }

      Arrays.sort(numbers);

      for (int i = 0; i < n-1; i++) {
        if (numbers[i+1].startsWith(numbers[i])) {
          possible = false;
          break;
        }
      }

      System.out.println(possible ? "YES" : "NO");
      
    }

   }

}