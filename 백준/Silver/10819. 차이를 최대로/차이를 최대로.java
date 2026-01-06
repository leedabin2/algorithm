import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[] A;
    static int answer = -100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        
        A = new int[N];
        for (int i = 0; i < N; i++) {
          A[i] = Integer.parseInt(st[i]);
        }
        
        dfs(0);

        System.out.println(answer);
    }
    static void dfs(int depth) {
        
        if (depth == N) {
          int sum = 0;
          for (int i = 0; i < N-1; i++) {
            sum += Math.abs(A[i] - A[i+1]);
          }
          answer = Math.max(answer, sum);
          return;
        }
        
        // 순서를 바꿔보기
        for (int i = depth; i < N; i++) {
          swap(depth, i);
          dfs(depth + 1);
          swap(i, depth);
        }
    }
    static void swap(int a, int b) {
      int temp = A[a];
      A[a] = A[b];
      A[b] = temp;
    }
}