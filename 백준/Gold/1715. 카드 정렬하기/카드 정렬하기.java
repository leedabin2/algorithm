import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] card = new int[N];

    for (int i =0; i < N; i++) {
      card[i] = Integer.parseInt(br.readLine());
    }


    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
        pq.add(card[i]);
    }
    int total = 0;

    while(pq.size() > 1){
      int first = pq.poll();
      int second = pq.poll();

      int sum = first + second;
      total += sum;


      pq.add(sum);
    }

    System.out.println(total);
  }
} 