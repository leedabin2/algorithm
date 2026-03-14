import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();

    Deque<Character> dq = new ArrayDeque<>();
    dq.add(S.charAt(0));

    for (int i = 1; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c <= dq.peekFirst()) dq.addFirst(c);
      else dq.addLast(c);
    }
    
    StringBuilder sb = new StringBuilder();
    while (!dq.isEmpty()) {
      sb.append(dq.poll());
    }

    System.out.println(sb.toString());

   }
}