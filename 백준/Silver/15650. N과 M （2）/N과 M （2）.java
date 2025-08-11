import java.util.*;
import java.io.*;

class Main {
  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    N = Integer.parseInt(st[0]);
   M = Integer.parseInt(st[1]);

    int[] arr = new int[N];

    for (int i = 1; i <= N; i++) {
      arr[i-1] = i;
    }
    List<Integer> unique = new ArrayList<>();

    find(unique, 0, arr);
  }
  private static void find(List<Integer> unique, int idx, int[] arr) {
    if (M == unique.size()) {
      for (int i =0; i < unique.size(); i++) {
        System.out.print(unique.get(i));  
        if (i != M - 1) System.out.print(" ");

      }
      System.out.println();
      return;
    }

    for (int i = idx; i < N; i++) {
      if (!unique.contains(arr[i])) {
        unique.add(arr[i]);
        find(unique, i + 1, arr);
        unique.remove(unique.size()-1);
      }
    }
  }
} 