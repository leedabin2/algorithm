import java.util.*;
import java.io.*;

class Main {
  static Set<Character> vowels = Set.of('a','e','i','o','u');
  
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      String input = br.readLine();
      if (input.equals("end")) break;

      if (check(input)) {
          System.out.println("<" + input + "> is acceptable.");
      } else {
          System.out.println("<" + input + "> is not acceptable.");
      }

      }
      
      
    }
    static boolean check(String s) {
      boolean hasVowel = false;
      int vowelCnt = 0;
      int consonantCnt = 0;
      char prev = 0;

      for (char ch : s.toCharArray()) {
        // 모음 체크
        boolean isVowel = vowels.contains(ch);
        if (isVowel) {
          vowelCnt++;
          consonantCnt = 0;
          hasVowel = true;

        } else {
          consonantCnt++;
          vowelCnt = 0;
        }

           if (consonantCnt >= 3 || vowelCnt >= 3) {
          return false;
        } else if (prev == ch) {
          if (!(ch == 'e' || ch == 'o')) return false;
        }

        prev = ch;
      }

      return hasVowel;

    }
  
  
}