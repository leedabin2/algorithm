import java.util.*;
import java.io.*;

class Main {
  static int N;
  static int[] numbers;
  static int max = Integer.MIN_VALUE;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    String[] st = br.readLine().split(" ");
    
    numbers = new int[N];
    for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st[i]);

    String[] func = br.readLine().split(" ");

    int add = Integer.parseInt(func[0]); 
    int minus = Integer.parseInt(func[1]); 
    int multi = Integer.parseInt(func[2]); 
    int div = Integer.parseInt(func[3]);

    dfs(1 ,numbers[0], add, minus, multi, div);
    System.out.println(max);
    System.out.println(min);

  }
  static void dfs(int idx, int num,int add, int minus, int multi, int div) {
    if (idx == N) {
      max = Math.max(num, max);
      min = Math.min(num, min);
      return;
    }

    if (add > 0) {
      dfs(idx+1, num + numbers[idx], add-1, minus, multi, div);
    }
    if (minus > 0) {
      dfs(idx+1, num - numbers[idx], add, minus-1, multi, div);
    }
    if (multi > 0) {
      dfs(idx+1, num * numbers[idx], add, minus, multi-1, div);
    }
    if (div > 0) {
      int next;
      if (num < 0) {
        next = -(-num / numbers[idx]);
      } else {
        next = num / numbers[idx];
      }
      dfs(idx+1, next, add, minus, multi, div-1);
    }
  }
} 