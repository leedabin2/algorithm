import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      while (true) { 
        String s = br.readLine();
        if (s.equals(".")) return;

        Stack<Character> stack = new Stack<>();
        boolean ok =true;
        for (char ch : s.toCharArray()) {

          if (ch == '(' || ch == '[') {
            stack.add(ch);
          }

          else if (ch == ')') {
            if (stack.isEmpty() || stack.peek() != '(') {
              ok = false;
              break;
            }
            stack.pop();
          }

          else if (ch == ']') {
            if (stack.isEmpty() || stack.peek() != '[') {
              ok = false;
              break;
            }
            stack.pop();
          }
          
        }

        if (!stack.isEmpty()) ok = false;

        System.out.println(ok ? "yes" : "no");

        
      }
   }
}