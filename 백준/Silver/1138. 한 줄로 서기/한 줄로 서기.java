import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String[] input = br.readLine().split(" ");

    int[] result = new int[N];

    // 키작은 사람부터 배치
    for (int i = 0; i < N; i++) {
      int h = Integer.parseInt(input[i]);

      // 왼쪽부터 빈칸 세기
      int cnt = 0;
      for (int j = 0; j < N; j++) {
        if (result[j] == 0) {
          if (cnt == h) {
            result[j] = i+1;
            break;
          }
          cnt++;
        }
      }
    }

    for (int num : result) {
      System.out.print(num + " ");
    }



   }
}