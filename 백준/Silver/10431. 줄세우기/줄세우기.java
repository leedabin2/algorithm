import java.io.*;
import java.util.*;

class Main {
  static int N = 20;
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int P = Integer.parseInt(br.readLine());

    while (P-- > 0) {

      String[] st = br.readLine().split(" ");
      int T = Integer.parseInt(st[0]);

      int back = 0;
      int[] students = new int[N];
      for (int i = 1; i <= N; i++) {
        students[i-1] = Integer.parseInt(st[i]);
      }

      Deque<Integer> line = new ArrayDeque<>();

      for (int i = 0; i < N; i++) {
        int cur = students[i];

        if (line.isEmpty()) { // 첫학생이라면
          line.add(cur);
        }
        else {
          Deque<Integer> temp = new ArrayDeque<>();

          // 현재학생보다 큰 학생 찾기
          while (!line.isEmpty() && line.peekLast() > cur) {
            temp.addFirst(line.pollLast());
            back++;
          }

          line.addLast(cur);

          // 원래대로
          while (!temp.isEmpty()) {

            line.addLast(temp.pollFirst());
            
          }
        }
      }

      System.out.println(T + " " + back);

      
    }

   }
}