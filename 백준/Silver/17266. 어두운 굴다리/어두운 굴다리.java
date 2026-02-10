import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] info = br.readLine().split(" ");
        int[] lamp = new int[M];

        for (int i = 0; i < M; i++) {
            lamp[i] = Integer.parseInt(info[i]);
        }

        int H = 0;

        // 1. 시작
        H = Math.max(H, lamp[0]);

        // 2. 가운데
        for (int i = 1; i < M; i++) {
          int gap = lamp[i] - lamp[i-1];
          H = Math.max(H, (gap+1)/2);
        }

        // 3. 마지막
        H = Math.max(H, N - lamp[M-1]);

        System.out.println(H);
    }
}
