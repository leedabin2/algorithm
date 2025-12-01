import java.io.*;
import java.util.*;
class Main {
  static int N, M;
  static int[] arr;
  static boolean[] visited;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] st = br.readLine().split(" ");

      N = Integer.parseInt(st[0]);
     M = Integer.parseInt(st[1]);


      arr = new int[N];
      visited = new boolean[N];

      String[] row = br.readLine().split(" ");
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(row[i]);
      }

      Arrays.sort(arr);

    dfs(0,  "");


   }
   static void dfs(int depth, String nums) {
    if (depth == M) {
      System.out.println(nums);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (nums.equals("")) {
            dfs(depth + 1, arr[i] + "");
        } else {
            dfs(depth + 1, nums + " " + arr[i]);
        }
        visited[i] = false;
      }
    }
   }
}
