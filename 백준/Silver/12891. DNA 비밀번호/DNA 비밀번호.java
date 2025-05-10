import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int S = Integer.parseInt(st[0]);
    int P = Integer.parseInt(st[1]);

    char[] passwords = br.readLine().toCharArray();

    String[] number = br.readLine().split(" ");
    int a = Integer.parseInt(number[0]);
    int c = Integer.parseInt(number[1]);
    int g = Integer.parseInt(number[2]);
    int t = Integer.parseInt(number[3]);

    int ca = 0, cc = 0, cg = 0, ct = 0;

    for (int i = 0; i < P; i++) {
      if (passwords[i] == 'A') ca++;
      if (passwords[i] == 'C') cc++;
      if (passwords[i] == 'G') cg++;
      if (passwords[i] == 'T') ct++;
    }

    int count = 0;
    if (ca >= a && cc >= c && cg >= g && ct >= t) count++;

    for (int i = P; i < S; i++) {
    
      char out = passwords[i - P];
      if (out == 'A') ca--;
      if (out == 'C') cc--;
      if (out == 'G') cg--;
      if (out == 'T') ct--;


      char in = passwords[i];
      if (in == 'A') ca++;
      if (in == 'C') cc++;
      if (in == 'G') cg++;
      if (in == 'T') ct++;

      if (ca >= a && cc >= c && cg >= g && ct >= t) count++;
    }

    System.out.println(count);
  }
}
