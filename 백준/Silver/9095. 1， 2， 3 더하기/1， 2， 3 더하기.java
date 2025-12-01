import java.io.*;

class Main {
  static int[] arr = new int[]{1, 2, 3};
  static int cnt;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int T = Integer.parseInt(br.readLine());

      while (T-- > 0) {
        int n = Integer.parseInt(br.readLine());
        cnt = 0;
        dfs(0, n); // 합,  n
        System.out.println(cnt);
        
      }
   }
   static void dfs(int sum, int n) {
    if (sum == n) {
      cnt++;
      return;
    }

    if (sum > n) return; 

    for (int i = 0; i < 3; i++) {
      sum += arr[i];
      dfs(sum, n);
      sum -= arr[i];
    }
   }
}