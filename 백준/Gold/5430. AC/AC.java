import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
          String p = br.readLine();
          int n = Integer.parseInt(br.readLine());
          String strArr = br.readLine();

          Deque<Integer> q = new ArrayDeque<>();
          if (n > 0) {
            String[] nums = strArr.substring(1, strArr.length()-1).split(",");
            for (String num : nums) {
              q.add(Integer.parseInt(num.trim()));
            }
          }

          boolean isReversed = false;
          boolean isError = false;

          for (char cmd : p.toCharArray()) {
            if (cmd == 'R') {
              isReversed = !isReversed;
            } else if (cmd == 'D') {
              if (q.isEmpty()) {
                isError = true;
                break;
              }

              if (isReversed) {
                q.removeLast();
              } else {
                q.removeFirst();
              }
            } 
          }

          if (isError) {
            sb.append("error\n");
          } else {
            sb.append("[");
            if (!q.isEmpty()) {
              if (isReversed) {
                sb.append(q.removeLast());
                while(!q.isEmpty()) {
                  sb.append(",").append(q.removeLast());;
                }

              } else {
                sb.append(q.removeFirst());
                while(!q.isEmpty()) {
                  sb.append(",").append(q.removeFirst());
                }

              }
            }
            sb.append("]\n"); 
          }
        }

        System.out.println(sb);
    }
}