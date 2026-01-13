import java.io.*;
import java.util.Stack;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      int[][] skyLine = new int[N][2];
      for (int i = 0; i < N; i++) {
        String[] row = br.readLine().split(" ");

        int x = Integer.parseInt(row[0]);
        int y = Integer.parseInt(row[1]);

        skyLine[i][0] = x;
        skyLine[i][1] = y;
      }

      Stack<Integer> stack = new Stack<>();
      int answer = 0;
      for (int i = 0; i < N; i++) {

        while (!stack.isEmpty() && skyLine[stack.peek()][1] > skyLine[i][1]) {
          
          if(skyLine[stack.peek()][1] > 0) answer++;
          stack.pop();
        }

        if(!stack.isEmpty() && skyLine[stack.peek()][1] == skyLine[i][1]) continue;

        stack.push(i);
      }

      while (!stack.isEmpty()) {
        if (skyLine[stack.peek()][1] > 0) answer++;
        stack.pop();
        
      }

      System.out.println(answer);

   }
}