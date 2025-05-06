import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] st = br.readLine().split(" ");
    int[] height = new int[N];

    for (int i = 0; i < N; i++) {
      height[i] = Integer.parseInt(st[i]);
    }

    Stack<Integer> stack = new Stack<>();  
    int[] answer = new int[N];

    for (int i = 0 ; i < N; i++) {

      while(!stack.isEmpty() && height[stack.peek()] < height[i] ) {
        stack.pop();
      }

      if (!stack.isEmpty()) {
        answer[i] = stack.peek() + 1;
      } else {
        answer[i] = 0;
      }

      stack.push(i);
    }

    for (int a : answer) {
      System.out.print(a + " ");
    }

  }
}