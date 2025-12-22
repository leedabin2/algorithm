import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      String[] st = br.readLine().split(" ");
      int[] a = new int[N];

      for (int i =0; i < N; i++) {
        a[i] = Integer.parseInt(st[i]);
      }

      List<Integer> list = new ArrayList<>();

      for (int x : a ) {
        if (list.isEmpty() || list.get(list.size()-1) < x) {
          list.add(x);
        }else {
          int idx = findIndex(list, x);
          list.set(idx, x);
        }
      }

      System.out.println(list.size());

   }
   static int findIndex(List<Integer> list, int target) {
    
    int left = 0;
    int right = list.size()-1;

    while (left < right) {

      int mid = (left + right) / 2;

      if (list.get(mid) < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    
    return left;
   }

}