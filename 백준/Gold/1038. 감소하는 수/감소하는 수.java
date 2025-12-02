import java.io.*;
import java.util.*;
class Main {
  static int N;
  static ArrayList<Long> list = new ArrayList<>();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int cnt = 0;

      N = Integer.parseInt(br.readLine());

      for (int i = 0; i < 10; i++) {
        dfs(i, i);
      }

      Collections.sort(list);

      System.out.println(N >= list.size() ? -1 : list.get(N));

   }
   static void dfs(long curr, long last) {
    list.add(curr);

    for (int next = 0; next < last; next++) {
      dfs(curr * 10 + next, next);
    }


   }
}