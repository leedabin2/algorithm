import java.io.*;
import java.util.*;

class Main {
  static final int N = 9;
  static int[] height;
  static boolean ok = false;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      height = new int[N];

      for (int i =0; i < N; i++) {
        height[i] = Integer.parseInt(br.readLine());
      }

      dfs(new ArrayList<>(), 0);
      
   }
   static void dfs(List<Integer> lst, int start) {
    if (ok) return;

    if (lst.size() == 7) {
      if (isPossible(lst)) {
        printLst(lst);
      }
      return;
    }

    for (int i = start; i < N; i++) {
      lst.add(height[i]);
      dfs(lst, i+1);
      lst.remove(lst.size()-1);
    }
   }

   static boolean isPossible(List<Integer> lst) {
    
    int sum = 0;
    for (int l : lst) {
      sum += l;
      if (sum > 100) return false;
    }

    if (sum == 100) {
      ok = true;
      return true;
    }
    return false;
   }

   static void printLst(List<Integer> lst) {
    Collections.sort(lst);

    for (int l : lst) {
      System.out.println(l);
    }

   }
}