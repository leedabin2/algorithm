import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    Deque<Integer> queue = new ArrayDeque<>();

    int N = Integer.parseInt(br.readLine());
    for (int i = 1; i <N+1; i++) {
      queue.add(i);
    }

    while( queue.size() > 1) {
      queue.poll();
      queue.add(queue.poll());
    }

    System.out.print(queue.peek());
  }
}