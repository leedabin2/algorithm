import java.util.*;
import java.io.*;

class Main {
  static int H, W;
  static int[] arr;
  static int answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");

    H = Integer.parseInt(st[0]);
    W = Integer.parseInt(st[1]);
    answer = 0;
    arr = new int[W];
    String[] line = br.readLine().split(" ");
  
    for (int i = 0; i < W; i++) {
      arr[i] = Integer.parseInt(line[i]);
    }

    for (int i = 1; i < W-1; i++) {
      int left = 0;
      int right = 0;

      for (int j = 0; j < i; j++) {
        if (left < arr[j]) {
          left = arr[j];
        }
      }

      for (int j = i+1; j < W; j++) {
        if (right < arr[j]) {
          right = arr[j];
        }
      }

      int minHeight = Math.min(left,right);

      if (arr[i] < minHeight) {
        answer += minHeight - arr[i];
      }

    }

     System.out.println(answer);
  }
}