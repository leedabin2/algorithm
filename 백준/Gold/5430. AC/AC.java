import java.io.*;
import java.util.*;
class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int T = Integer.parseInt(br.readLine());

      while (T-- > 0) {
        char[] p = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        String arr = br.readLine();
        arr = arr.substring(1, arr.length()-1);
        Deque<Integer> queue = new ArrayDeque<>();
        if (!arr.isEmpty()) {
          String[] num = arr.split(",");
          for (String s : num) {
            queue.add(Integer.parseInt(s));
          }
        }

        boolean isReverse = false;
        boolean error = false;
        for (char cmd : p) {
          if (cmd == 'R') {
            isReverse = !isReverse;
          } else if (cmd == 'D') {
            if (queue.isEmpty()) {
              System.out.println("error");
              error = true;
              break;
            } else {
              if (isReverse) {
                // 뒤집은 경우라면
                queue.pollLast();
              } else {
                queue.pollFirst();
              }
            }
          }
        }

        if (error) continue;

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!queue.isEmpty()) {
          sb.append(isReverse ? queue.pollLast() : queue.pollFirst());
          if (!queue.isEmpty()) sb.append(",");
        }
        sb.append("]");
        System.out.println(sb.toString());

      }
   }
}