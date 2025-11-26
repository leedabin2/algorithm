import java.util.*;
import java.io.*;

class Main {
  public static void main (String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String numbers = br.readLine();
    int total = 0;
    for (String ch : numbers.split("")) {
      int digit = Integer.parseInt(ch);
      total += digit;
    }

    System.out.println(total);
  
  }
}