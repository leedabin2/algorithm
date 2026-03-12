import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());
    
    int[] x = new int[N];
    String[] st = br.readLine().split(" ");
    for (int i = 0; i  < N; i++) {
      x[i] = Integer.parseInt(st[i]);
    }

    Arrays.sort(x);

    // 인접차구함
    int[] diff = new int[N-1];
    int max = 0;
    for (int i = 1; i < N; i++) {
      diff[i-1] = Math.abs(x[i]-x[i-1]);
      if (max < diff[i-1]) max = diff[i-1];
  
    }
    // 가장 큰 차이를 K-1 개 제거
    Arrays.sort(diff);
    
    int remove = K-1;
    for (int i = diff.length - 1; i >= 0 && remove > 0; i--) {
        diff[i] = 0;
        remove--;
    }

    // 남은 차이의 합이 정답
    int answer = 0;
    for (int i = 0; i < diff.length; i++) {
      answer += diff[i];
    }

    System.out.println(answer);

   }
}