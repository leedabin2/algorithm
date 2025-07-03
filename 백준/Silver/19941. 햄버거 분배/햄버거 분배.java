import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));


    String[] st = br.readLine().split(" ");

    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);
    int eat = 0;


    boolean[] eaten = new boolean[N]; 
    String row = br.readLine();
    char[] line = row.toCharArray();


    for (int i = 0; i < N; i++) {
      if (line[i] == 'P') {
        int left = Math.max(0,i-K);
        int right = Math.min(N-1,i+K);
   
        for (int j = left; j <= right; j++) {
          if (line[j] == 'H' && !eaten[j]) {
            eat++;
            eaten[j] = true;
            break;
          }
        }

      }
    }

    System.out.println(eat);
   }
} 