import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      int[] top = new int[N];
      String[] st = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
        top[i] = Integer.parseInt(st[i]);
      }

      Deque<Integer> stack = new ArrayDeque<>();
      int[] answer = new int[N];

      for (int i = N-1; i >= 0; i--) {
        
        while (!stack.isEmpty() && top[stack.peek()] <= top[i]) {
          int pop = stack.poll();
          answer[pop] = i+1;
        }

        stack.addFirst(i);
      }

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < N; i++) {
        sb.append(answer[i]).append(" ");
      }

      System.out.println(sb.toString().trim());
   }

}