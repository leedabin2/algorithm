import java.io.*;
import java.util.*;

class Main {
  static class Node {
    Map<String, Node> child = new TreeMap<>();
  }
  static Node root = new Node();
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      int K = Integer.parseInt(input[0]);

      Node current = root;
      for (int j = 1; j <= K; j++) {
        current.child.putIfAbsent(input[j], new Node());
        current = current.child.get(input[j]);
      }
    }

    print(root, 0);
   }
   static void print(Node node, int depth) {
    for (String key : node.child.keySet()) {
      for (int i = 0; i < depth; i++) {
        System.out.print("--");
      }
      System.out.println(key);
      print(node.child.get(key), depth + 1);
    }
   }
}