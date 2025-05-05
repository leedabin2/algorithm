import java.util.*;
import java.io.*;
class Main {
 
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    while (true) {
      String[] st = br.readLine().split(" ");
      int a = Integer.parseInt(st[0]);
      int b = Integer.parseInt(st[1]);
      int c = Integer.parseInt(st[2]);

      if (a == 0 && b == 0 && c ==0 ) {
        return;
      }

      int maxLength = Math.max(a,Math.max(b,c));
      int sum = a + b + c - maxLength;
   
      if (maxLength >= sum) {
        System.out.println("Invalid");
      }
      else if  (a == b && b == c && a == c) {
        System.out.println("Equilateral");
        
      } else if ( (a == b && b != c) || (a == c && a != b ) || (b == c && c != a)) {
        System.out.println("Isosceles");
      }
      else if ( a != b && b != c && a != c) {
        System.out.println("Scalene");
      }
      
    }

    
  
  }

}