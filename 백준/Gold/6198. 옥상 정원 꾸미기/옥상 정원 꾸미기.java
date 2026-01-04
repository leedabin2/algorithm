import java.util.*;
import java.io.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        Deque<Integer> dq = new ArrayDeque<>();
        int[] h = new int[N];
        
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }
        
        long total = 0;
        for (int i = 0; i < N; i++) {
            // 현재 빌딩보다 작거나 같은 높이면 제거
            while(!dq.isEmpty() && h[dq.peek()] <= h[i]) {
              dq.poll();
            }

            total += dq.size();
            
            dq.addFirst(i);
        }
        
        System.out.println(total);
    }
}
    
    