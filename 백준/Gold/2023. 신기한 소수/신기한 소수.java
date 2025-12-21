import java.io.*;

class Main {
  static int N;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());
      
      dfs(0, "");
   }
   static void dfs(int depth, String num) {
    if (depth == N) {
      System.out.println(num);
      return;
    }

    for (int i = 1; i < 10; i++) {
      String next = num + i;
      if (isPrime(Integer.parseInt(next))) dfs(depth + 1, next);
    }
   }

   static boolean isPrime(int num) {
    if (num < 2) return false;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) return false;
    }
    return true;
   }

}