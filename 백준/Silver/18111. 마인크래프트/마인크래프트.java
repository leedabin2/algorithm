import java.util.*;
import java.io.*;


class Main  {
    static int[] height;
    static int N, M, inventory;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);
        inventory = Integer.parseInt(st[2]);

        height = new int[257];
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                height[board[i][j]]++;
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = -1;

        for (int target = 0; target < 257; target++) {
            int time = 0;
            int block = inventory;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int current = board[i][j];
                    int diff = current - target;
                    if (diff > 0) {
                        time += diff * 2;
                        block += diff;
                    } else if (diff < 0) {
                        time += -diff;
                        block -= -diff;
                    }
                }
            }

            if (block >= 0) {
                if (time < resultTime || (time == resultTime && target > resultHeight)) {
                    resultTime = time;
                    resultHeight = target;
                }
            }
        }

        System.out.println(resultTime + " " + resultHeight);

    }
}
