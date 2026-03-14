import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] st = br.readLine().split(" ");

    int[] team = new int[N*2];
    for (int i = 0 ; i < N*2; i++) {
      team[i] = Integer.parseInt(st[i]);
    }
    Arrays.sort(team);

    int min = Integer.MAX_VALUE;
    
    for (int i = 0; i < N; i++) {
      min = Math.min(min, team[i] + team[N*2-1-i]);
    }

    System.out.println(min);


   }
}