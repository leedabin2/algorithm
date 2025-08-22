import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] number = new int[N];
    for (int i = 0; i < N; i++) {
      number[i] = Integer.parseInt(br.readLine());
    }

    StringBuilder sb = new StringBuilder();
    Stack<Integer> st = new Stack<>();
    int max = 0;
    boolean possible = true;

    for (int i = 0; i < N; i++) {
      int num = number[i];

      // 목표 숫자가 아직 push되지 않았으면 push
      for (int j = max + 1; j <= num; j++) {
        st.push(j);
        sb.append("+\n");
        max = j;
      }


      if (!st.isEmpty() && st.peek() == num) {
        st.pop();
        sb.append("-\n");
      } else {
        possible = false;
        break;
      }
    }

    if (possible) {
      System.out.println(sb);
    } else {
      System.out.println("NO");
    }
  }
}
