import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int j =1; j <= T; j++) {
      int[] alphabet = new int[26];

      String input = br.readLine();

      for (char ch : input.toCharArray()) {
        
        if (Character.isLetter(ch)) alphabet[Character.toLowerCase(ch) - 'a']++;
        
      }

      int min = Integer.MAX_VALUE;
      boolean isPangram = true;

      for (int i = 0; i < 26; i++) {
          if (alphabet[i] == 0) {
            isPangram = false;
            break;
          }
          min = Math.min(min, alphabet[i]);
      }

      if (!isPangram) {
        System.out.println("Case " + j + ": Not a pangram");
      } else if (min >= 3) {
        System.out.println("Case " + j + ": Triple pangram!!!");
      } else if (min == 2) {
        System.out.println("Case " + j + ": Double pangram!!");
      } else {
        System.out.println("Case " + j + ": Pangram!");
      }
    }
    
  
   
   }
} 