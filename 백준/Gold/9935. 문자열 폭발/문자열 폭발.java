import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    // 1 : 55 - > 2 : 45

    String[] input = br.readLine().split("");
    String bomb = br.readLine();

    char[] b = bomb.toCharArray();
    int len = input.length;

    int m = bomb.length();

    Deque<Character> queue = new ArrayDeque<>();
    for (int i = 0; i < len; i++) {
      char ch = input[i].charAt(0);
      queue.addLast(ch);
      
      if (b[m-1] == ch && queue.size() >= m) {
        char[] buf = new char[m];
        boolean isMatch = true;
        for (int j = m-1; j >= 0; j--) {
          char x = queue.removeLast();
          buf[j] = x;
          if (b[j] != x) {
            isMatch = false;
          }
        }

        if (!isMatch) {
          for (int j = 0; j < m; j++) {
            queue.addLast(buf[j]);
          }
        }

      
      }


    }


    StringBuilder sb = new StringBuilder(queue.size());

    if (queue.isEmpty()) {
      System.out.println("FRULA");
    } else {
      while(!queue.isEmpty()) {
      char curr = queue.poll();
        sb.append(curr);
      }
      System.out.println(sb);
    }

  }
} 