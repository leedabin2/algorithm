import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int k = Integer.parseInt(br.readLine());

    Deque<Integer> stack = new ArrayDeque<>();
    long answer = 0;
    for (int i = 0; i < k; i++) {
      int num =Integer.parseInt(br.readLine());

      if (num == 0) {
        // 지움
        stack.pollLast();
      } else {
        stack.addLast(num);
      }
    }

    for (int num : stack) {
      answer += num;
    }

    System.out.println(answer);
   }
}