import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    Deque<Character> left = new ArrayDeque<>();
    Deque<Character> right = new ArrayDeque<>();

    for (char in : input.toCharArray()) {
      left.addLast(in);
    }

    int N = Integer.parseInt(br.readLine());

    for (int i =0; i < N; i++) {
      String[] cmd = br.readLine().split(" ");
      switch(cmd[0]) {
        case "P":
          left.addLast(cmd[1].charAt(0));
          break;
        case "L":
          if (!left.isEmpty()) right.addFirst(left.pollLast());
          break;
        case "D":
          if (!right.isEmpty()) left.addLast(right.pollFirst());
          break;
        case "B":
          if (!left.isEmpty()) left.pollLast();
          break;
        
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : left) sb.append(c);
    for (char c : right) sb.append(c);
    System.out.println(sb);

  }
}