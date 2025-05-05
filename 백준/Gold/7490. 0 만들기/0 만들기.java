import java.util.*;
import java.io.*;

class Main {
  static int N;
  static List<String> result = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      N = Integer.parseInt(br.readLine());
      result.clear();
      dfs(1,"1");
      Collections.sort(result);
      for (String s : result) {
        System.out.println(s);
      }
       System.out.println();
    }
    
  }

  static void dfs(int depth, String exp) {
    if (depth == N) {
      if (calculate(exp.replace(" ","")) == 0) {
        result.add(exp);
      }
      return;
    }

    dfs(depth + 1, exp +" " + (depth +1));
    dfs(depth + 1, exp + "+" + (depth + 1));
    dfs(depth + 1, exp + "-" + (depth + 1));


  }

  static int calculate(String exp) {
    int sum = 0;
    int num = 0;
    char sign = '+';
    for (int i = 0; i < exp.length(); i++ ) {
      char ch = exp.charAt(i);

      if (Character.isDigit(ch)) {
        num = num * 10 + (ch - '0');
      }

      if (!Character.isDigit(ch) || i == exp.length() - 1 ) {
        if (sign == '+') sum += num;
        else if (sign == '-') sum -= num;

        sign = ch;
        num = 0;
      }

     
    }
     return sum;
  }


}