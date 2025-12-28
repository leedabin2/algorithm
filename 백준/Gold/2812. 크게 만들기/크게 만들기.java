import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      // 맨 앞 3자리에서 가장 작은 거 지우기
      // 여러개라면 맨 앞을 지우기

      String[] st = br.readLine().split(" ");

      int N = Integer.parseInt(st[0]);
      int K = Integer.parseInt(st[1]);

      String num = br.readLine();

      Deque<Character> queue = new ArrayDeque<>();


      for (int i = 0; i < num.length(); i++) {

        char c = num.charAt(i);

        while (!queue.isEmpty() && K > 0 && queue.peekLast() < c) {
          queue.pollLast();
          K--;
        }
        
        queue.addLast(c);
      }

      while (K-- > 0) {
        queue.pollLast();
      }

      StringBuilder sb = new StringBuilder();
      while (!queue.isEmpty()) {
        sb.append(queue.poll());
      }

      System.out.println(sb);
    
      

      
      



   }
}