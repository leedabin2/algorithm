import java.io.*;
import java.util.*;

class Main {

    static int H, W, N;
    static char[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        H = Integer.parseInt(st[0]);
        W = Integer.parseInt(st[1]);
        N = Integer.parseInt(st[2]);

        board = new char[H][W];

        int sx = 0, sy = 0;
        int[][] cheesePos = new int[N + 1][2];

        for (int i = 0; i < H; i++) {
            String row = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = row.charAt(j);

                if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }

                if (board[i][j] >= '1' && board[i][j] <= (char)(N + '0')) {
                    int idx = board[i][j] - '0';
                    cheesePos[idx][0] = i;
                    cheesePos[idx][1] = j;
                }
            }
        }

        int total = 0;

        for (int cheese = 1; cheese <= N; cheese++) {
            int dist = bfs(sx, sy, cheesePos[cheese][0], cheesePos[cheese][1]);
            total += dist;

            sx = cheesePos[cheese][0];
            sy = cheesePos[cheese][1];
        }

        System.out.println(total);
    }

    static int bfs(int sx, int sy, int tx, int ty) {

        boolean[][] visited = new boolean[H][W];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == tx && y == ty) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}