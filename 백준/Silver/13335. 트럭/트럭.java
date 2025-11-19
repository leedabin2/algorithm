import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int w = Integer.parseInt(st[1]);
    int L = Integer.parseInt(st[2]);

    Deque<Integer> waiting = new ArrayDeque<>();
    String[] ws = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      waiting.add(Integer.parseInt(ws[i]));
    }

    Deque<Integer> bridge = new ArrayDeque<>();
    for (int i = 0; i < w; i++) bridge.add(0);

    int time = 0;
    int total = 0;

    while (!waiting.isEmpty() || total > 0) {
      time++;

      total -= bridge.pollFirst();

      if (!waiting.isEmpty() && total + waiting.peekFirst() <= L) {
        int truck = waiting.pollFirst();
        bridge.addLast(truck);
        total += truck;
      } else {
        bridge.addLast(0);
      }
    }

    System.out.println(time);
  }
}
