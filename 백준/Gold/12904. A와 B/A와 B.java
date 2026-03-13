import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();
    String T = br.readLine();

    boolean reverse = false;

    // 마지막이 A면 뒤에 A를 제거
    // 마지막이 B면 B제거후뒤집기 -> reverse 면 앞을 제거

    Deque<Character> queue = new ArrayDeque<>();
    for (int i = 0; i < T.length(); i++) {
      queue.add(T.charAt(i));
    }

    while (queue.size() > S.length()) {
      if (reverse) {
        char first = queue.pollFirst();
        if (first == 'B') {
          reverse = !reverse;
        }
      } else {
        char last = queue.pollLast();
        
        if (last == 'B') {
          reverse = !reverse;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) { {
      if (!reverse) sb.append(queue.pollFirst());
      else sb.append(queue.pollLast());
    }
      
    }

    System.out.println(sb.toString().equals(S) ? 1 : 0);

    

   }
}