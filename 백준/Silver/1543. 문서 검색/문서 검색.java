import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    char[] input = br.readLine().toCharArray();
    char[] word = br.readLine().toCharArray();


    int count = 0;
    int i = 0;

    while(i <= input.length - word.length) {
      boolean match = true;

      for (int j = 0; j < word.length; j++) {
        if(input[i+j] != word[j]) {
          match = false;
          break;
        }
      }

      if (match) {
        count++;
        i += word.length;
      } else {
        i++;
      }
    }
    System.out.println(count);

  }
} 