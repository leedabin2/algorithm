import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    
    int[] switches = new int[N];
    String[] st = br.readLine().split(" ");
    for (int i = 0; i < N; i++) switches[i] = Integer.parseInt(st[i]);

    int student = Integer.parseInt(br.readLine());

    for (int i = 0; i < student; i++) {
      String[] line = br.readLine().split(" ");
      int gender = Integer.parseInt(line[0]);
      int num = Integer.parseInt(line[1])-1;

      if (gender == 1) {
  
        for (int j = num; j < N; j += (num + 1)) {
          switches[j] ^= 1;
        }
      }

      else {

        int left = num-1;
        int right = num+1;

        while(left >= 0 && right < N && switches[left] == switches[right]) {
          left--;
          right++;
        }
        for (int j = left+1; j <= right-1; j++) {
          switches[j] ^= 1;
        }


      }
    }

    for (int i = 0; i < N; i++) {
      System.out.print(switches[i] + " ");
      if ((i+1) % 20 == 0 ) System.out.println();
    }
  }
}