import java.io.*;

class Main {
  static int alarm = 45;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String[] st = br.readLine().split(" ");

       int H = Integer.parseInt(st[0]);
       int M = Integer.parseInt(st[1]);

       int tomin = toMin(H, M);
       
       System.out.println(result(tomin));
    }
    static int toMin(int h , int m) {
      return h * 60 + m;
    }
    static String result(int t) {
      int total = t - alarm;

      if (total < 0) total += 24 * 60; // 하루더하기

      int h = total /60;
      int m = total  % 60;
      
      return h + " " + m;
    }
  }