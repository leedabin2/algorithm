import java.util.*;
import java.io.*;

class Main {
  static int[][] board;
  static int n, m;
  static int[][] directions = {{0,1}, {-1,0}, {0,-1}, {1,0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    n = Integer.parseInt(st[0]);
    m = Integer.parseInt(st[1]);

    int[] trees = new int[n];

    String[] st1 = br.readLine().split(" ");
    
    int high = 0;

    for (int i =0; i < n; i++) {
      trees[i] = Integer.parseInt(st1[i]);
      high = Math.max(high, trees[i]);
    } 

    int left = 0;
    int right = high;
    int answer = 0;
  
    while(left <= right) {
      
      int mid = left + (right - left) / 2;
      long cut = 0;

      for (int tree : trees) {
        if (tree > mid) {
          cut += tree - mid;
        }
      }

      if (cut >= m) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    
    }

    System.out.println(answer);

    
  }
}
