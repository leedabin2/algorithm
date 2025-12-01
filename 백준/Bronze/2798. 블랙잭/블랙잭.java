import java.io.*;

class Main {
  static int max = 0;
  static int N, M;
  static int[] numbers;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");
      N = Integer.parseInt(st[0]);
      M = Integer.parseInt(st[1]);

      String[] arr = br.readLine().split(" ");

      numbers = new int[N];
      for (int i = 0; i < N; i++) {
        numbers[i] = Integer.parseInt(arr[i]);
      }

      dfs(0, 0, 0); 

      System.out.println(max);
   }
   static void dfs(int depth, int start, int sum) {
    
    if (depth == 3) {
      if (sum <= M) max = Math.max(max, sum);
      return;
    }

    for (int i = start; i < N; i++) {
      if (sum + numbers[i] > M) continue;
      dfs(depth + 1, i + 1, sum + numbers[i]);
    }
   }
}