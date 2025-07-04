import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    Map<Character, Integer> alphabet = new HashMap<>();

    int[] value = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    for (int i = 0; i < 26; i++) {
      char ch = (char) ('A' + i);
      alphabet.put(ch, value[i]);
    }

    String he = br.readLine();
    String she = br.readLine();

    List<Integer> score = new ArrayList<>();

    int len = he.length();
    for (int i = 0; i < len; i++) {
      score.add(alphabet.get(he.charAt(i)));
      score.add(alphabet.get(she.charAt(i)));
    }


    while(score.size() > 2) {
      List<Integer> next = new ArrayList<>();
      
      for (int i =0; i< score.size() - 1 ; i++) {
        int sum = score.get(i) + score.get(i+1);
        next.add(sum % 10);
      }

      score = next;
      
    }

    System.out.println(score.get(0) + ""+ score.get(1));

  

    

    
  }
} 