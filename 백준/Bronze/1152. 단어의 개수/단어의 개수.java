import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine().trim();
    if (input.isEmpty()) {
      System.out.println(0);
    } else {
      String[] words = input.split("\\s+"); 
      System.out.println(words.length);
    }
    
  }
} 
