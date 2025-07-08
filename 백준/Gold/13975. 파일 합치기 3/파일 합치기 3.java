import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      int K = Integer.parseInt(br.readLine());

      String[] st = br.readLine().split(" ");

      long[] file = new long[K];

      for (int i =0; i < K; i++) {
        file[i] = Long.parseLong(st[i]);
      }

      PriorityQueue<Long> pq = new PriorityQueue<>();

      for (int i = 0; i < K; i++) {
        pq.add(file[i]);
      }

      long total = 0;

      while(pq.size() > 1) {
        long first = pq.poll();
        long second = pq.poll();

        long sum = first + second;
        total += sum;

        pq.add(sum);
      }

      System.out.println(total);
    }
  }
} 