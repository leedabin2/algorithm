import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int N = Integer.parseInt(st[0]);
    int K = Integer.parseInt(st[1]);

    int[] gold = new int[N+1];
    int[] silver = new int[N+1];
    int[] bronze = new int[N+1];

    for (int i = 0; i < N; i++) {
      String[] info = br.readLine().split(" ");
      int n = Integer.parseInt(info[0]);
      int g = Integer.parseInt(info[1]);
      int s = Integer.parseInt(info[2]);
      int b = Integer.parseInt(info[3]);

      gold[n] = g;
      silver[n] = s;
      bronze[n] = b;
    }


    int rank = 1;
    for (int i = 1; i <= N; i++) {
      if (i == K) continue;

      if (gold[i] > gold[K]) {
        rank++;
      } else if (gold[i] == gold[K] && silver[i] > silver[K]) {
        rank++;
      } else if (gold[i] == gold[K] && silver[i] == silver[K] && bronze[i] > bronze[K]) {
        rank++;
      }
    }

    System.out.println(rank);
   }
}