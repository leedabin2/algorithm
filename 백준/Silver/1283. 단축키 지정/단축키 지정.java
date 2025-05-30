import java.util.*;
import java.io.*;

public class Main {
  static int N;
  static Set<Character> usedKeys = new HashSet<>(); 

  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    for (int line = 0; line < N; line++) {
      String input = br.readLine();
      String[] words = input.split(" ");
      boolean assigned = false;

    
      for (int i = 0; i < words.length; i++) {
        char firstChar = Character.toUpperCase(words[i].charAt(0));
        if (!usedKeys.contains(firstChar)) {
          usedKeys.add(firstChar);
          words[i] = "[" + words[i].charAt(0) + "]" + words[i].substring(1);
          assigned = true;
          break;
        }
      }

    
      if (!assigned) {
        outer:
        for (int i = 0; i < input.length(); i++) {
          char c = input.charAt(i);
          if (c != ' ') {
            char upperC = Character.toUpperCase(c);
            if (!usedKeys.contains(upperC)) {
              usedKeys.add(upperC);
              input = input.substring(0, i) + "[" + c + "]" + input.substring(i + 1);
              break outer;
            }
          }
        }
        System.out.println(input);
      } else {
        System.out.println(String.join(" ", words));
      }
    }
  }
}
