import java.io.*;
import java.util.*;
class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int T = Integer.parseInt(br.readLine());

      for (int i =0; i < T; i++) {
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean isVps = true;
        for (char ch : s.toCharArray()) {

          if (ch == '(') {
            stack.push(ch);
          }
          else if (ch == ')') {
            if (stack.isEmpty() || stack.peek() != '(') {
              isVps = false;
              break;
            }
            stack.pop();
          }
        }

        if (!stack.isEmpty()) isVps = false;

        if (isVps) System.out.println("YES");
        else System.out.println("NO");
        

      }
   }
}