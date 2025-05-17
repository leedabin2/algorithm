import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i =0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num != 0) {
        minHeap.add(num);
      } else {
        if (!minHeap.isEmpty()) {
          System.out.println(minHeap.poll());
        } else {
          System.out.println(0);
        }
      }
    }

   
  }
} 