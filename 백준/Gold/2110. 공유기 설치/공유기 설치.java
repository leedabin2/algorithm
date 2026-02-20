import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");

    int N = Integer.parseInt(st[0]);
    int C = Integer.parseInt(st[1]);

    long[] house = new long[N];

    for (int i = 0; i < N; i++) {
      house[i] = Long.parseLong(br.readLine());
    }

    Arrays.sort(house);
    // 1 2 4 8 9 
    long answer = 0;

    long left = 0;
    long right = house[N-1] - house[0];
    
    while (left <= right) {

      long mid = (left + right) / 2; 

      int cnt = 1;
      long last = house[0];

      for (int i = 1; i < N; i++) {
        if (house[i] - last >= mid) {
          // 가장 인접한 공유기의 거리가 최대가 되도록
          cnt++;
          last = house[i];
        }
      }

      if (cnt >= C) {
        answer = mid;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
      
    }

    System.out.println(answer);

    
   }
}