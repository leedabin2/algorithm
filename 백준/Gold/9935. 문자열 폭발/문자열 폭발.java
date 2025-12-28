import java.util.*;
import java.io.*;

class Main {
  public static void main (String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    String bomb = br.readLine();
    int len = bomb.length();

    StringBuilder stack = new StringBuilder();

    for (char ch : s.toCharArray()) {

      stack.append(ch);

      if (stack.length() >= len) {
        boolean match = true;

        for (int i = 0; i < len; i++) {
          if (stack.charAt(stack.length()-len + i) != bomb.charAt(i)) {
            match = false;
            break;
          }
        }

        if (match) {
          // 폭발
          stack.delete(stack.length()-len, stack.length());
        }
      }
    }

    if (stack.length() == 0) System.out.println("FRULA");
    else System.out.println(stack.toString());

  }
}
